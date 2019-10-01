DECLARE @sid_in vARcHaR(100); -- ID no data type
SET @sid_in = 'S-1-5-21-789336058-1580436667-1343024091-34374 /*this is NOT a comment*/'; -- a string

DECLARE @sql NVARCHAR(MAX) = 'CREATE LOGIN [URL\dagutierrez] WITH SID = ' + CONVERT(VARCHAR(64), CONVERT(BINARY(16),SID_BINARY(@sid_in)), 1) + ';'; -- nvarchar as ID,  SID_BINARY as ID

PRINT @sql
EXEC sys.sp_executesql @sql;

/*--DECLARE @sid_in varchar(100);
--SET @sid_in = 'S-1-5-21-789336058-/*Another comment*/1580436667-1343024091-34374';*/

-- DECLARE @number varchar(100);

SELECT SUSER_SNAME(CONVERT(BINARY(16),SID_BINARY(@sid_in))); -- id

ALTER TABLE [dbo].[InformeViajes] DROP CONSTRAINT [CK__InformeVi__Pasaj__6D0D32F4]
GO
ALTER TABLE [dbo].[Reparaciones] DROP CONSTRAINT [FK__Reparacio__Placa__619B8048]
GO
ALTER TABLE [dbo].[Reparaciones] DROP CONSTRAINT [FK__Reparacio__NIT_M__60A75C0F]
GO
ALTER TABLE [dbo].[Piezas] DROP CONSTRAINT [FK__Piezas__NITProve__5DCAEF64]
GO
ALTER TABLE [dbo].[Paradas] DROP CONSTRAINT [FK__Paradas__CodigoR__68487DD7]
GO
ALTER TABLE [dbo].[Mecanico] DROP CONSTRAINT [FK__Mecanico__NITMec__534D60F1]
GO
ALTER TABLE [dbo].[InformeViajes] DROP CONSTRAINT [FK__InformeVi__Placa__6C190EBB]
GO

CREATE TABLE [dbo].[AutoBus](
	[Placa] [nvarchar](128) NOT NULL,
	[Marca] [nvarchar](128) NULL,
	[Modelo] [nvarchar](128) NULL,
	[A�o] [int] NULL,
	[FechaAdquisicion] [date] NULL,
	[Color] [nvarchar](128) NULL,
	[NumAscientos] [int] NULL,
	[Longitud] [int] NULL,
	[Anchura] [int] NULL,
	[Potencia] [int] NULL,
	[Transmision] [nvarchar](128) NULL,
	[Kilometraje] [int] NULL,
	[A�oVida] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[Placa] ASC
)
) ON [PRIMARY]
GO

DECLARE @number INT; -- ID no data type
SET @number = +0000000000000000000000000000001; -- an int

DECLARE @var CHAR(100);
set @var = ?'$';

/****** Object:  Database [LineaDiamante]    Script Date: 8/26/2019 10:03:13 PM ******/
DROP DATABASE [LineaDiamante]
GO
/****** Object:  Database [LineaDiamante]    Script Date: 8/26/2019 10:03:13 PM ******/
CREATE DATABASE [LineaDiamante]
 CONTAINMENT = NULL
 ON  PRIMARY 
( NAME = 'LineaDiamante', FILENAME = 'D:\NDocuments\SQL\MSSQL14.MSSQLSERVER\MSSQL\DATA\LineaDiamante.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 00000012.e-2 ) -- valid float
 LOG ON 
( NAME = 'LineaDiamante_log', FILENAME = 'D:\NDocuments\SQL\MSSQL14.MSSQLSERVER\MSSQL\Log\LineaDiamante_log.ldf' , SIZE = 0x8192KB , MAXSIZE = 2048GB , FILEGROWTH = .12E0000000002 ) -- incorrect float
GO

DECLARE @path VARCHAR(MAX); 
SET @path = ' This a string without ending
not the same string, all should be ids except _thiserror';


/* comment without ending, should continue

ALTER DATABASE [LineaDiamante] SET COMPATIBILITY_LEVEL = 120
GO
IF (1 = SERVERPROPERTYGLOBALFULLTEXTSERVICEGENERALPROPERTY('IsFullTextInstalled')) -- id too long
begin
EXEC [LineaDiamante].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO

