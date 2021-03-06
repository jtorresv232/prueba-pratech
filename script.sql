USE [master]
GO
/****** Object:  Database [pratest]    Script Date: 19/12/2020 2:45:38 a. m. ******/
CREATE DATABASE [pratest]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'pratest', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\pratest.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'pratest_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\pratest_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [pratest] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [pratest].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [pratest] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [pratest] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [pratest] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [pratest] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [pratest] SET ARITHABORT OFF 
GO
ALTER DATABASE [pratest] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [pratest] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [pratest] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [pratest] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [pratest] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [pratest] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [pratest] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [pratest] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [pratest] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [pratest] SET  DISABLE_BROKER 
GO
ALTER DATABASE [pratest] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [pratest] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [pratest] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [pratest] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [pratest] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [pratest] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [pratest] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [pratest] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [pratest] SET  MULTI_USER 
GO
ALTER DATABASE [pratest] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [pratest] SET DB_CHAINING OFF 
GO
ALTER DATABASE [pratest] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [pratest] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [pratest] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [pratest] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
ALTER DATABASE [pratest] SET QUERY_STORE = OFF
GO
USE [pratest]
GO
/****** Object:  Table [dbo].[answer]    Script Date: 19/12/2020 2:45:38 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[answer](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[answer] [varchar](255) NULL,
	[question_id] [int] NULL,
	[try_id] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[app_user]    Script Date: 19/12/2020 2:45:38 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[app_user](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[email] [varchar](255) NULL,
	[name] [varchar](255) NOT NULL,
	[password] [varchar](255) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[form]    Script Date: 19/12/2020 2:45:38 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[form](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[form_name] [varchar](255) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[form_answered]    Script Date: 19/12/2020 2:45:38 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[form_answered](
	[user_id] [int] NOT NULL,
	[form_id] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[user_id] ASC,
	[form_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[question]    Script Date: 19/12/2020 2:45:38 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[question](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[question] [varchar](255) NOT NULL,
	[type] [varchar](255) NOT NULL,
	[form_id] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[try]    Script Date: 19/12/2020 2:45:38 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[try](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[user_id] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[validation]    Script Date: 19/12/2020 2:45:38 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[validation](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[type] [varchar](255) NULL,
	[value] [varchar](255) NULL,
	[question_id] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[app_user] ON 

INSERT [dbo].[app_user] ([id], [email], [name], [password]) VALUES (1, N'jtorresv232@gmail.com', N'Jonathan', N'123456789')
SET IDENTITY_INSERT [dbo].[app_user] OFF
GO
SET IDENTITY_INSERT [dbo].[form] ON 

INSERT [dbo].[form] ([id], [form_name]) VALUES (1, N'Agrega un amigo')
SET IDENTITY_INSERT [dbo].[form] OFF
GO
SET IDENTITY_INSERT [dbo].[question] ON 

INSERT [dbo].[question] ([id], [question], [type], [form_id]) VALUES (1, N'Nombre', N'text', 1)
INSERT [dbo].[question] ([id], [question], [type], [form_id]) VALUES (2, N'Apellido', N'text', 1)
INSERT [dbo].[question] ([id], [question], [type], [form_id]) VALUES (3, N'Edad', N'number', 1)
INSERT [dbo].[question] ([id], [question], [type], [form_id]) VALUES (4, N'Fecha Nacimiento', N'date', 1)
INSERT [dbo].[question] ([id], [question], [type], [form_id]) VALUES (5, N'Celular', N'number', 1)
INSERT [dbo].[question] ([id], [question], [type], [form_id]) VALUES (6, N'Tel fijo', N'number', 1)
INSERT [dbo].[question] ([id], [question], [type], [form_id]) VALUES (7, N'Estudia?', N'checkbox', 1)
INSERT [dbo].[question] ([id], [question], [type], [form_id]) VALUES (8, N'Trabaja?', N'checkbox', 1)
INSERT [dbo].[question] ([id], [question], [type], [form_id]) VALUES (9, N'Correo', N'email', 1)
SET IDENTITY_INSERT [dbo].[question] OFF
GO
SET IDENTITY_INSERT [dbo].[validation] ON 

INSERT [dbo].[validation] ([id], [type], [value], [question_id]) VALUES (1, N'minLength', N'4', 1)
INSERT [dbo].[validation] ([id], [type], [value], [question_id]) VALUES (2, N'maxLength', N'15', 1)
INSERT [dbo].[validation] ([id], [type], [value], [question_id]) VALUES (3, N'required', N'true', 1)
INSERT [dbo].[validation] ([id], [type], [value], [question_id]) VALUES (4, N'required', N'true', 2)
INSERT [dbo].[validation] ([id], [type], [value], [question_id]) VALUES (5, N'minLength', N'3', 2)
INSERT [dbo].[validation] ([id], [type], [value], [question_id]) VALUES (6, N'maxLength', N'15', 2)
INSERT [dbo].[validation] ([id], [type], [value], [question_id]) VALUES (7, N'required', N'true', 3)
INSERT [dbo].[validation] ([id], [type], [value], [question_id]) VALUES (8, N'required', N'true', 4)
INSERT [dbo].[validation] ([id], [type], [value], [question_id]) VALUES (9, N'required', N'true', 5)
INSERT [dbo].[validation] ([id], [type], [value], [question_id]) VALUES (10, N'minLength', N'10', 5)
INSERT [dbo].[validation] ([id], [type], [value], [question_id]) VALUES (11, N'minLength', N'7', 6)
INSERT [dbo].[validation] ([id], [type], [value], [question_id]) VALUES (12, N'required', N'7', 9)
INSERT [dbo].[validation] ([id], [type], [value], [question_id]) VALUES (13, N'email', N'true', 9)
SET IDENTITY_INSERT [dbo].[validation] OFF
GO
ALTER TABLE [dbo].[answer]  WITH CHECK ADD  CONSTRAINT [FK8frr4bcabmmeyyu60qt7iiblo] FOREIGN KEY([question_id])
REFERENCES [dbo].[question] ([id])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[answer] CHECK CONSTRAINT [FK8frr4bcabmmeyyu60qt7iiblo]
GO
ALTER TABLE [dbo].[answer]  WITH CHECK ADD  CONSTRAINT [FKfyk8lnx6n78rgsdlf714x7aq6] FOREIGN KEY([try_id])
REFERENCES [dbo].[try] ([id])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[answer] CHECK CONSTRAINT [FKfyk8lnx6n78rgsdlf714x7aq6]
GO
ALTER TABLE [dbo].[form_answered]  WITH CHECK ADD  CONSTRAINT [FK5w4jw315jx1309d07l80vne53] FOREIGN KEY([user_id])
REFERENCES [dbo].[app_user] ([id])
GO
ALTER TABLE [dbo].[form_answered] CHECK CONSTRAINT [FK5w4jw315jx1309d07l80vne53]
GO
ALTER TABLE [dbo].[form_answered]  WITH CHECK ADD  CONSTRAINT [FKdta70rrx9209kdm3uwxgm2m8m] FOREIGN KEY([form_id])
REFERENCES [dbo].[form] ([id])
GO
ALTER TABLE [dbo].[form_answered] CHECK CONSTRAINT [FKdta70rrx9209kdm3uwxgm2m8m]
GO
ALTER TABLE [dbo].[question]  WITH CHECK ADD  CONSTRAINT [FKfufwr8jclqwc3bw2d2tj4957f] FOREIGN KEY([form_id])
REFERENCES [dbo].[form] ([id])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[question] CHECK CONSTRAINT [FKfufwr8jclqwc3bw2d2tj4957f]
GO
ALTER TABLE [dbo].[try]  WITH CHECK ADD  CONSTRAINT [FK1sv0bknqvcds4hs76d0i3j9mw] FOREIGN KEY([user_id])
REFERENCES [dbo].[app_user] ([id])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[try] CHECK CONSTRAINT [FK1sv0bknqvcds4hs76d0i3j9mw]
GO
ALTER TABLE [dbo].[validation]  WITH CHECK ADD  CONSTRAINT [FK20nj3aish6y3bpsou8jxkiyg9] FOREIGN KEY([question_id])
REFERENCES [dbo].[question] ([id])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[validation] CHECK CONSTRAINT [FK20nj3aish6y3bpsou8jxkiyg9]
GO
USE [master]
GO
ALTER DATABASE [pratest] SET  READ_WRITE 
GO
