/*==============================================================*/
/* DBMS name:      Microsoft SQL Server 2017                    */
/* Created on:     2022-10-16 2:14:23 PM                        */
/*==============================================================*/


if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('DAILYNUTRITIONGOAL') and o.name = 'FK_DAILYNUT_HAS2_USER')
alter table DAILYNUTRITIONGOAL
   drop constraint FK_DAILYNUT_HAS2_USER
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('EXERCISE') and o.name = 'FK_EXERCISE_DO_USER')
alter table EXERCISE
   drop constraint FK_EXERCISE_DO_USER
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('EXERCISE') and o.name = 'FK_EXERCISE_IS_EXERCISE')
alter table EXERCISE
   drop constraint FK_EXERCISE_IS_EXERCISE
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('MEAL') and o.name = 'FK_MEAL_EAT_USER')
alter table MEAL
   drop constraint FK_MEAL_EAT_USER
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('MEALITEM') and o.name = 'FK_MEALITEM_CONTAINS_MEAL')
alter table MEALITEM
   drop constraint FK_MEALITEM_CONTAINS_MEAL
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('"USER"') and o.name = 'FK_USER_HAS_ROLE_USERROLE')
alter table "USER"
   drop constraint FK_USER_HAS_ROLE_USERROLE
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('USERHEALTHINFO') and o.name = 'FK_USERHEAL_ABOUT2_USER')
alter table USERHEALTHINFO
   drop constraint FK_USERHEAL_ABOUT2_USER
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('DAILYNUTRITIONGOAL')
            and   name  = 'HAS2_FK'
            and   indid > 0
            and   indid < 255)
   drop index DAILYNUTRITIONGOAL.HAS2_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('DAILYNUTRITIONGOAL')
            and   type = 'U')
   drop table DAILYNUTRITIONGOAL
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('EXERCISE')
            and   name  = 'IS_FK'
            and   indid > 0
            and   indid < 255)
   drop index EXERCISE.IS_FK
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('EXERCISE')
            and   name  = 'DO_FK'
            and   indid > 0
            and   indid < 255)
   drop index EXERCISE.DO_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('EXERCISE')
            and   type = 'U')
   drop table EXERCISE
go

if exists (select 1
            from  sysobjects
           where  id = object_id('EXERCISETYPES')
            and   type = 'U')
   drop table EXERCISETYPES
go

if exists (select 1
            from  sysobjects
           where  id = object_id('LOGIN')
            and   type = 'U')
   drop table LOGIN
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('MEAL')
            and   name  = 'EAT_FK'
            and   indid > 0
            and   indid < 255)
   drop index MEAL.EAT_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('MEAL')
            and   type = 'U')
   drop table MEAL
go

if exists (select 1
            from  sysobjects
           where  id = object_id('MEALITEM')
            and   type = 'U')
   drop table MEALITEM
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('"USER"')
            and   name  = 'HAS_ROLE_FK'
            and   indid > 0
            and   indid < 255)
   drop index "USER".HAS_ROLE_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('"USER"')
            and   type = 'U')
   drop table "USER"
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('USERHEALTHINFO')
            and   name  = 'ABOUT2_FK'
            and   indid > 0
            and   indid < 255)
   drop index USERHEALTHINFO.ABOUT2_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('USERHEALTHINFO')
            and   type = 'U')
   drop table USERHEALTHINFO
go

if exists (select 1
            from  sysobjects
           where  id = object_id('USERROLE')
            and   type = 'U')
   drop table USERROLE
go

/*==============================================================*/
/* Table: DAILYNUTRITIONGOAL                                    */
/*==============================================================*/
create table DAILYNUTRITIONGOAL (
   USERID               int                  not null,
   CALORIE              decimal              not null,
   PROTEIN              decimal              not null,
   FAT                  decimal              not null,
   CARB                 decimal              not null
)
go

/*==============================================================*/
/* Index: HAS2_FK                                               */
/*==============================================================*/




create nonclustered index HAS2_FK on DAILYNUTRITIONGOAL (USERID ASC)
go

/*==============================================================*/
/* Table: EXERCISE                                              */
/*==============================================================*/
create table EXERCISE (
   DATETIME             datetime             not null,
   USERID               int                  not null,
   EXERCISEID           int                  not null,
   NAME                 varchar(256)         not null,
   DURATION             decimal              not null,
   CALORIE              decimal              not null,
   constraint PK_EXERCISE primary key (DATETIME, USERID)
)
go

/*==============================================================*/
/* Index: DO_FK                                                 */
/*==============================================================*/




create nonclustered index DO_FK on EXERCISE (USERID ASC)
go

/*==============================================================*/
/* Index: IS_FK                                                 */
/*==============================================================*/




create nonclustered index IS_FK on EXERCISE (EXERCISEID ASC)
go

/*==============================================================*/
/* Table: EXERCISETYPES                                         */
/*==============================================================*/
create table EXERCISETYPES (
   EXERCISEID           int                  not null,
   EXERCISENAME         varchar(256)         not null,
   CALPERHOUR           decimal              not null,
   constraint PK_EXERCISETYPES primary key (EXERCISEID)
)
go

/*==============================================================*/
/* Table: LOGIN                                                 */
/*==============================================================*/
create table LOGIN (
   LOGINID              int                  not null IDENTITY(1,1),
   USERNAME             varchar(256)         not null,
   PASSWORDSALT         varchar(256)         not null,
   PASSWORDHASH         varchar(256)         not null,
   USER_ID              int                  null,
   constraint PK_LOGIN primary key (LOGINID)
)
go

/*==============================================================*/
/* Table: MEAL                                                  */
/*==============================================================*/
create table MEAL (
   MEALNAME             varchar(256)         not null,
   MEALDATETIME         datetime             not null,
   USERID               int                  not null,
   CALORIE              decimal              not null,
   PROTEIN              decimal              not null,
   FAT                  decimal              not null,
   CARB                 decimal              not null,
   constraint PK_MEAL primary key (MEALNAME, MEALDATETIME, USERID)
)
go

/*==============================================================*/
/* Index: EAT_FK                                                */
/*==============================================================*/




create nonclustered index EAT_FK on MEAL (USERID ASC)
go

/*==============================================================*/
/* Table: MEALITEM                                              */
/*==============================================================*/
create table MEALITEM (
   MEALNAME             varchar(256)         not null,
   MEALDATETIME         datetime             not null,
   USERID               int                  not null,
   ITEMNAME             varchar(256)         not null,
   CALORIE              decimal              not null,
   PROTEIN              decimal              not null,
   FAT                  decimal              not null,
   CARB                 decimal              not null,
   constraint PK_MEALITEM primary key (MEALNAME, MEALDATETIME, USERID)
)
go

/*==============================================================*/
/* Table: "USER"                                                */
/*==============================================================*/
create table "USER" (
   USERID               int                  not null,
   USERROLEID           int                  not null,
   FIRSTNAME            varchar(256)         not null,
   LASTNAME             varchar(256)         not null,
   EMAILADDRESS         varchar(256)                  not null,
   PHONENUMBER          char(256)            not null,
   constraint PK_USER primary key (USERID)
)
go

/*==============================================================*/
/* Index: HAS_ROLE_FK                                           */
/*==============================================================*/




create nonclustered index HAS_ROLE_FK on "USER" (USERROLEID ASC)
go

/*==============================================================*/
/* Table: USERHEALTHINFO                                        */
/*==============================================================*/
create table USERHEALTHINFO (
   USERID               int                  not null,
   GENDER               varchar(256)         not null,
   HEIGHT               decimal              not null,
   WEIGHT               decimal              not null,
   ACTIVENESS           tinyint              not null,
   AGE                  int                  not null
)
go

/*==============================================================*/
/* Index: ABOUT2_FK                                             */
/*==============================================================*/




create nonclustered index ABOUT2_FK on USERHEALTHINFO (USERID ASC)
go

/*==============================================================*/
/* Table: USERROLE                                              */
/*==============================================================*/
create table USERROLE (
   USERROLEID           int                  not null,
   ROLENAME             varchar(256)         not null,
   constraint PK_USERROLE primary key (USERROLEID)
)
go

alter table DAILYNUTRITIONGOAL
   add constraint FK_DAILYNUT_HAS2_USER foreign key (USERID)
      references "USER" (USERID)
go

alter table EXERCISE
   add constraint FK_EXERCISE_DO_USER foreign key (USERID)
      references "USER" (USERID)
go

alter table EXERCISE
   add constraint FK_EXERCISE_IS_EXERCISE foreign key (EXERCISEID)
      references EXERCISETYPES (EXERCISEID)
go

alter table MEAL
   add constraint FK_MEAL_EAT_USER foreign key (USERID)
      references "USER" (USERID)
go

alter table MEALITEM
   add constraint FK_MEALITEM_CONTAINS_MEAL foreign key (MEALNAME, MEALDATETIME, USERID)
      references MEAL (MEALNAME, MEALDATETIME, USERID)
go

alter table "USER"
   add constraint FK_USER_HAS_ROLE_USERROLE foreign key (USERROLEID)
      references USERROLE (USERROLEID)
go

alter table USERHEALTHINFO
   add constraint FK_USERHEAL_ABOUT2_USER foreign key (USERID)
      references "USER" (USERID)
go


alter table mealitem drop constraint PK_MEALITEM

alter table mealtime
add primary key (MEALNAME,MEALDATETIME,USERID,ITEMNAME)

alter table EXERCISETYPES
add DESCRIPTION varchar(256) not null



--insert into dbo.USERROLE values (1, 'admin')
--insert into dbo.USERROLE values (2,'user')

--insert into login values('QuangPNCE170036','ufcid\''8+3+5(dfx[X','EFDSzBcs1si3ZmoLc8eGBQ==',1)
--insert into login values('THINHNLQCE161130','whekfx-0,5$0''fhzwt','c7kNDwbLaZzTbqkrcwUMwg==',2)
--insert into login values('hieuttnce161025','cnkqld0$7$9''0lnfcz','t1cjopqlaGSNcV/yngbL+g==',3)
--insert into login values('quyennnmce161096','aliojb4(5!4$7jlda^','PImPLLIXmT7nGE6N0GRg8g==',4)
--insert into login values('LUNTCE160464','paxdyq''1&0%0yaspm','SITVB27oFIubwPbUDbik3Q==',5)

--insert into dbo.[USER] values(1,1,'Quang', 'Pham', 'quangpnce170036@fpt.edu.vn', '0857974230')
--insert into dbo.[USER] values(2,1,'Thinh', 'Nguyen', 'THINHNLQCE161130@fpt.edu.vn', '000000000')
--insert into dbo.[USER] values(3,1,'Hieu', 'Tran', 'hieuttnce161025@fpt.edu.vn', '000000000')
--insert into dbo.[USER] values(4,1,'Quyen', 'Nguyen', 'quyennnmce161096@fpt.edu.vn', '000000000')
--insert into dbo.[USER] values(5,1,'Lu', 'Nguyen', 'LUNTCE160464@fpt.edu.vn', '000000000')