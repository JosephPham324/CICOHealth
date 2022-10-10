/*==============================================================*/
/* DBMS name:      Microsoft SQL Server 2017                    */
/* Created on:     2022-10-09 12:06:27 PM                       */
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
   where r.fkeyid = object_id('LOGIN') and o.name = 'FK_LOGIN_IS_USER')
alter table LOGIN
   drop constraint FK_LOGIN_IS_USER
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
   where r.fkeyid = object_id('"USER"') and o.name = 'FK_USER_IS2_LOGIN')
alter table "USER"
   drop constraint FK_USER_IS2_LOGIN
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
            from  sysindexes
           where  id    = object_id('LOGIN')
            and   name  = 'IS_FK'
            and   indid > 0
            and   indid < 255)
   drop index LOGIN.IS_FK
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
            from  sysindexes
           where  id    = object_id('MEALITEM')
            and   name  = 'CONTAINS_FK'
            and   indid > 0
            and   indid < 255)
   drop index MEALITEM.CONTAINS_FK
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
            from  sysindexes
           where  id    = object_id('"USER"')
            and   name  = 'IS2_FK'
            and   indid > 0
            and   indid < 255)
   drop index "USER".IS2_FK
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
   USERID               int                  null,
   CALORIE              decimal              null,
   PROTEIN              decimal              null,
   FAT                  decimal              null,
   CARB                 decimal              null
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
   EXERCISEID           int                  not null,
   DATETIME             datetime             not null,
   EXERCISENAME         varchar(256)         not null,
   CALPERHOUR           decimal              not null,
   USERID               int                  null,
   NAME                 varchar(256)         not null,
   DURATION             decimal              not null,
   CALORIE              decimal              not null,
   constraint PK_EXERCISE primary key (EXERCISEID, DATETIME)
)
go

/*==============================================================*/
/* Index: DO_FK                                                 */
/*==============================================================*/




create nonclustered index DO_FK on EXERCISE (USERID ASC)
go

/*==============================================================*/
/* Table: LOGIN                                                 */
/*==============================================================*/
create table LOGIN (
   LOGINID              int					 not null,
   USERID               int  					 null,
   USERNAME             varchar(256)         not null,
   PASSWORDSALT         varchar(256)         not null,
   PASSWORDHASH         varchar(256)         not null,
   constraint PK_LOGIN primary key (LOGINID)
)
go

--insert into LOGIN VALUES (1,1,'nlordqting4444','123','202cb962ac59075b964b07152d234b70')

/*==============================================================*/
/* Index: IS_FK                                                 */
/*==============================================================*/




create nonclustered index IS_FK on LOGIN (USERID ASC)
go

/*==============================================================*/
/* Table: MEAL                                                  */
/*==============================================================*/
create table MEAL (
   MEALNAME             varchar(256)         not null,
   MEALDATETIME         datetime             not null,
   USERID               int                  null,
   CALORIE              decimal              not null,
   PROTEIN              decimal              not null,
   FAT                  decimal              not null,
   CARB                 decimal              not null,
   constraint PK_MEAL primary key (MEALNAME, MEALDATETIME)
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
   MEALNAME             varchar(256)         null,
   MEALDATETIME         datetime             null,
   ITEMNAME             varchar(256)         not null,
   CALORIE              decimal              not null,
   PROTEIN              decimal              not null,
   FAT                  decimal              not null,
   CARB                 decimal              not null
)
go

/*==============================================================*/
/* Index: CONTAINS_FK                                           */
/*==============================================================*/




create nonclustered index CONTAINS_FK on MEALITEM (MEALNAME ASC,
  MEALDATETIME ASC)
go

/*==============================================================*/
/* Table: "USER"                                                */
/*==============================================================*/
create table "USER" (
   USERID               int                  not null,
   LOGINID              int                  null,
   USERROLEID           int                  null,
   FIRSTNAME            varchar(256)         not null,
   LASTNAME             varchar(256)         not null,
   EMAILADDRESS         varchar(256)               null,
   PHONENUMBER          char(256)            null,
   constraint PK_USER primary key (USERID)
)
go

--insert into [USER] VALUES (1,1,1,'Thinh','Nguyen','thinh@gmail.com','0916257956')



/*==============================================================*/
/* Index: IS2_FK                                                */
/*==============================================================*/




create nonclustered index IS2_FK on "USER" (LOGINID ASC)
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
   USERID               int                  null,
   GENDER               varchar(256)         not null,
   HEIGHT               decimal              not null,
   WEIGHT               decimal              not null,
   ACTIVENESS           tinyint              not null,
   AGE                  int                  not null
)
go

--insert into USERHEALTHINFO VALUES (1,'Male',180,60,1.2,20)



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

--insert into USERROLE VALUES (1,'GainWeight')


alter table DAILYNUTRITIONGOAL
   add constraint FK_DAILYNUT_HAS2_USER foreign key (USERID)
      references "USER" (USERID)
go

alter table EXERCISE
   add constraint FK_EXERCISE_DO_USER foreign key (USERID)
      references "USER" (USERID)
go

alter table LOGIN
   add constraint FK_LOGIN_IS_USER foreign key (USERID)
      references "USER" (USERID)
go

alter table MEAL
   add constraint FK_MEAL_EAT_USER foreign key (USERID)
      references "USER" (USERID)
go

alter table MEALITEM
   add constraint FK_MEALITEM_CONTAINS_MEAL foreign key (MEALNAME, MEALDATETIME)
      references MEAL (MEALNAME, MEALDATETIME)
go

alter table "USER"
   add constraint FK_USER_HAS_ROLE_USERROLE foreign key (USERROLEID)
      references USERROLE (USERROLEID)
go

alter table "USER"
   add constraint FK_USER_IS2_LOGIN foreign key (LOGINID)
      references LOGIN (LOGINID)
go

alter table USERHEALTHINFO
   add constraint FK_USERHEAL_ABOUT2_USER foreign key (USERID)
      references "USER" (USERID)
go

