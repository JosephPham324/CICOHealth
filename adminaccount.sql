USE [Nutrition]
GO
INSERT [dbo].[USER] ([USERID], [USERROLEID], [FIRSTNAME], [LASTNAME], [EMAILADDRESS], [PHONENUMBER]) VALUES (1, 1, N'admin', N'admin', N'admin@admin.admin', N'0912301012                                                                                                                                                                                                                                                   ')
GO
INSERT [dbo].[DAILYNUTRITIONGOAL] ([USERID], [CALORIE], [PROTEIN], [FAT], [CARB]) VALUES (1, CAST(2857.3 AS Decimal(18, 1)), CAST(178.6 AS Decimal(18, 1)), CAST(95.2 AS Decimal(18, 1)), CAST(321.4 AS Decimal(18, 1)))
GO
INSERT [dbo].[USERHEALTHINFO] ([USERID], [GENDER], [HEIGHT], [WEIGHT], [ACTIVENESS], [AGE]) VALUES (1, N'Male', CAST(180.0 AS Decimal(18, 1)), CAST(75.0 AS Decimal(18, 1)), 2, 20)
GO
SET IDENTITY_INSERT [dbo].[LOGIN] ON 
INSERT [dbo].[LOGIN] ([LOGINID], [USERNAME], [PASSWORDSALT], [PASSWORDHASH], [USER_ID]) VALUES (1, N'admin', N'jmvrwn"6-4#6opjmv', N'ZIZXXNGVnyrbk3MFF6Jmtw==', 32)
SET IDENTITY_INSERT [dbo].[LOGIN] OFF
GO
