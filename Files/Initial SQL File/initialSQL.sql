USE [CS319ProjectSQL];
GO

SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[ArtifactReview](
	[artifactReviewID] [int] NOT NULL,
	[assignmentID] [int] NULL,
	[artifactTitle] [varchar](150) NULL,
	[writerID] [int] NULL,
	[writer] [varchar](150) NULL,
	[text] [varchar](500) NULL,
	[date] [varchar](50) NULL,
 CONSTRAINT [PK_ArtifactReview] PRIMARY KEY CLUSTERED 
(
	[artifactReviewID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[Assignment](
	[assignmentID] [int] NOT NULL,
	[title] [varchar](50) NULL,
	[groupID] [int] NULL,
	[artifacts] [varchar](500) NULL,
	[description] [varchar](500) NULL,
	[grade] [float] NULL,
	[startDate] [varchar](50) NULL,
	[dueDate] [varchar](50) NULL,
 CONSTRAINT [PK_Assignment] PRIMARY KEY CLUSTERED 
(
	[assignmentID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[Group](
	[groupID] [int] NULL,
	[members] [varchar](500) NULL,
	[assignments] [varchar](500) NULL
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[PeerReview](
	[toStudent] [int] NULL,
	[giverID] [int] NULL,
	[description] [varchar](1000) NULL,
	[grade] [float] NULL,
	[date] [varchar](50) NULL
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[Student](
	[studentID] [int] NULL,
	[groupID] [int] NULL,
	[section] [int] NULL
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[User](
	[userID] [int] NULL,
	[name] [varchar](50) NULL,
	[surname] [varchar](50) NULL,
	[userType] [varchar](50) NULL,
	[email] [varchar](50) NULL,
	[passw] [varchar](50) NULL
) ON [PRIMARY]
GO

INSERT INTO [User]
VALUES (12345678, 'Cihan Can', 'Kýlýç', 'student', 'cck@email.com', '1234'), (98765432, 'Göktuð', 'Çaðýran', 'student', 'gc@email.com', '1234'), 
(1000, 'Eray', 'Tüzün', 'instructor', 'instructor@email.com', '1234'), (2000, 'Erdem', 'Tuna', 'ta', 'ta1@email.com', '1234'), (15975389, 'Anýl', 'Taþdan', 'student', 'anýl@email.com', '1234'), 
(74185296, 'Ahmet', 'Çakar', 'student', 'aç@email.com', '1234'), (96385274, 'Mustafa', 'Paçacý', 'student', 'mp@email.com', '1234'), (25689471, 'Tuna', 'Yýldýz', 'student', 'ty@email.com', '1234')
, (98653274, 'Batu Kaan', 'Akad', 'student', 'btk@email.com', '1234'), (87542196, 'Ýrem Küçükkiremitçi', 'Küçükkiremitçi', 'student', 'ik@email.com', '1234'), (32124565, 'Yaðmur', 'Çilsal', 'student', 'yc@email.com', '1234')
, (75385296, 'Kaya', 'Gülen', 'student', 'kg@email.com', '1234'), (54659887, 'Gökalp', 'Dolðun', 'student', 'gd@email.com', '1234'), (24863597, 'Atalay', 'Kutlay', 'student', 'atalay@email.com', '1234')
, (65498715, 'Zeynep', 'Sakaoðlu', 'student', 'zs@email.com', '1234'), (22154862, 'Pýnar', 'Þengür', 'student', 'ps@email.com', '1234'), (74851296, 'Arman', 'A', 'student', 'aa@email.com', '1234')
, (84976431, 'Can', 'Paçacý', 'student', 'cp@email.com', '1234'), (41587296, 'Mehmet', 'Demir', 'student', 'md@email.com', '1234'), (52681144, 'Ece', 'Palamutcu', 'student', 'ep@email.com', '1234')
, (11223344, 'Cem', 'Yýlmaz', 'student', 'cy@email.com', '1234'), (22334455, 'Ziya', 'Paçacý', 'student', 'zp@email.com', '1234'), (99887744, 'Ersin', 'Yaldýz', 'student', 'ey@email.com', '1234')
, (22558899, 'Murat', 'Büyük', 'student', 'mb@email.com', '1234'), (33559988, 'Öðrenci', 'Paçacý', 'student', 'op@email.com', '1234'), (11002288, 'Utku', 'Gül', 'student', 'ug@email.com', '1234');


INSERT INTO [Student]
VALUES (12345678, 1, 1), (98765432, 1, 1), (15975389, 1, 1), (74185296, 1, 1), (96385274, 1, 1)
, (25689471, 2, 1), (98653274, 2, 1), (87542196, 2, 1), (32124565, 2, 1), (75385296, 2, 1)
, (54659887, 3, 1), (24863597, 3, 1), (65498715, 3, 1), (41587296, 3, 1), (52681144, 3, 1);

INSERT INTO [Assignment]
VALUES(1,'Analysis Report',1,'Analysis1,Analysis2,Analysis3', 'Analysis Report Assignment', -1, '03/02/2021', '08/02/2021'), (2,'Analysis Report',2,'AnalysisIter1,AnalysisIter2,AnalysisIter3', 'Analysis Report Assignment', -1, '03/02/2021', '08/02/2021')
, (3,'Analysis Report',3,'AnalysisRep1,AnalysisRep2', 'Analysis Report Assignment', -1, '03/02/2021', '08/02/2021'), (4,'Design Report',1,'Design1,Design2,Design3', 'Design Report Assignment', -1, '03/02/2021', '08/02/2021')
, (5,'Design Report',2,'DesignIter1,DesignIter2,DesignIter3', 'Design Report Assignment', -1, '03/02/2021', '08/02/2021'), (6,'Design Report',3,'DesignRep1,DesignRep2,DesignRep3', 'Design Report Assignment', -1, '03/02/2021', '08/02/2021');
INSERT INTO [Group]
VALUES (1, '12345678,98765432,15975389,74185296,96385274', '1,4'), (2, '25689471,98653274,87542196,32124565,75385296', '2,5'), (3, '54659887,24863597,65498715,41587296,52681144', '3,6');
INSERT INTO [ArtifactReview]
VALUES (1,1,'Analysis1',12345678,'Cihan','Analysis 1 Review!!!', '18/05/2021'), (2,1,'Analysis1',98765432,'Göktuð','Analysis 1 Review!!!', '18/05/2021'), (3,1,'Analysis1',15975389,'Anýl','Analysis 1 Review!!!', '18/05/2021'), 
(4,1,'Analysis1',96385274,'Mustafa','Analysis 1 Review!!!', '18/05/2021'), (5,1,'Analysis1',1000,'Eray','Analysis 1 Review!!!', '18/05/2021'), (6,2,'AnalysisIter1',25689471,'Tuna','Analysis 1 Review!!!', '18/05/2021'), 
(7,2,'AnalysisIter1',98653274,'Batu Kaan','Analysis 1 Review!!!', '18/05/2021'), (8,2,'AnalysisIter1',87542196,'irem','Analysis 1 Review!!!', '18/05/2021'), (9,2,'AnalysisIter1',32124565,'Yaðmur','Analysis 1 Review!!!', '18/05/2021');
INSERT INTO [PeerReview]
VALUES(98765432, 12345678, 'Muazzam', 100, '07/05/2021'), (98765432, 15975389, 'Fevkalade', 100, '07/05/2021');
INSERT INTO [Student] (studentID)
SELECT userID
FROM [User]
WHERE (SELECT COUNT(1) FROM [Student] WHERE studentID = [User].userID) != 1;
UPDATE [Student]
SET groupID = -1
WHERE groupID IS NULL;
UPDATE [Student]
SET section = 1
WHERE section IS NULL;
DELETE FROM [Student]
WHERE studentID = 1000;
DELETE FROM [Student]
WHERE studentID = 2000;
SELECT * FROM [User];
SELECT * FROM [Student];
SELECT * FROM [Assignment];
SELECT * FROM [Group];
SELECT * FROM [ArtifactReview];
SELECT * FROM [PeerReview];
SELECT * FROM [Student];