-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: localhost    Database: akobot
-- ------------------------------------------------------
-- Server version	8.0.30

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `ksat`
--

DROP TABLE IF EXISTS `ksat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ksat` (
  `school_key` int NOT NULL,
  `field` varchar(50) NOT NULL,
  `document` varchar(50) NOT NULL,
  `condition_text` varchar(1000) DEFAULT NULL,
  `else_data` varchar(1000) DEFAULT NULL,
  `point` varchar(1000) DEFAULT NULL,
  `level` int NOT NULL,
  `fname` varchar(20) DEFAULT NULL,
  `dname` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`school_key`,`field`,`document`),
  CONSTRAINT `school-jungsi` FOREIGN KEY (`school_key`) REFERENCES `school` (`school_key`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ksat`
--

LOCK TABLES `ksat` WRITE;
/*!40000 ALTER TABLE `ksat` DISABLE KEYS */;
INSERT INTO `ksat` VALUES (11111,'ksat','ksat_basic','국내/외 고교 졸업(예정)자 또는 법령에 의하여 이와 동등 이상의 학력이 있다고 인정되는 자(외국 검정고시 합격자 제외)로서 우리대학 모집단위별로 요구하는 해당연도 대학수학능력시험 반영영역에 응시하여 성적을 취득한 자','\"\"','인문계열 / 자연계열 / 영화영상학과는 수능 100%로 바로 합격자를 뽑아! 체육교육과 / 조소 전공은 수능 60% 실기 40%로 바로 합격자를 뽑아!',4,'정시','기초생활수급자및차상위계층'),(11111,'ksat','ksat_farming','농어촌 지역 또는 도서/벽지 교육진흥법 제2조에 따른 고등학교 졸업(예정)자로서 우리대학 모집단위별로 요구하는 해당연도 대학수학능력시험 반영영역에 응시하여 성적을 취득하고 아래 중 하나에 해당하는 자 \\n 유형1: 농어촌지역 중/고등학교에서 중학교 입학일부터 고등학교 졸업(예정)일까지 전 교육과정을 연속으로 이수(예정)하고, 6년 동안 부/모/학생 모두가 농어촌지역에 거주한 자\\n 유형2: 농어촌지역 초/중/고등학교에서 초등학교 입학일부터 고등학교 졸업(예정)일까지 전 교육과정을 연속으로 이수(예정)하고, 12년 동안 학생이 농어촌지역에 거주한 자','\"\"','수능 100%로 바로 합격자를 뽑아!',4,'정시','농어촌전형'),(11111,'ksat','ksat_incumbent','아래 중 하나에 해당하는 자로서 산업체 근무경력이 통산 3년 이상인 재직자\\n 초/중등교육법시행령 제76조의3제1호에 따른 일반고등학교에서 재학하는 동안 시도 교육감이 직업교육훈련 촉진법에 따른 직업교육훈련기관 중 직업교육훈련 위탁기관으로 선정한 기관에서 1년 이상의 직업교육훈련과정을 이수하고 해당 일반고등학교를 졸업한 자\\n 초/중등교육법시행령 제90조제1항제10호에 따른 산업수요 맞춤형 고등학교를 졸업한 자\\n 특성화고등학교 등을 졸업한 자\\n 평생교육법 제31조제2항에 따른 학력인정 평생교육시설 중 특성화고등학교 등에서 제공하는 것과 같은 교육과정을 운영하는 평생교육시설에서 해당 교육과정을 이수한 자','\"\"','수능 최저는 적용하지 않고, 학생부 교과 70%, 서류 종합 30%로 합격자를 뽑아!',4,'정시','재직자'),(11111,'ksat','ksat_ksat','','아래에서 궁금한 전형을 말해줘!\\n[일반 전형] , [농어촌 전형] , [특성화고교 졸업자 전형] , [기초생활수급자 및 차상위계층 전형] , [재직자 전형]','',1,'정시','정시'),(11111,'ksat','ksat_normal','국내/외 고교 졸업(예정)자 또는 법령에 의하여 이와 동등 이상의 학력이 있다고 인정되 는 자(외국 검정고시 합격자 제외)로서 우리대학 모집단위별로 요구하는 해당연도 대학수학능력시험 반영영역에 응시하여 성적을 취득한 자','\"\"','수능 100%로 바로 합격자를 뽑아',4,'정시','일반전형'),(11111,'ksat','ksat_specialized','특성화고등학교 졸업(예정)자로서 우리대학 모집단위별로 요구하는 해당연도 대학수학능력시험 반영영역에 응시하여 성적을 취득하고 고교 이수 과와 우리대학 지원 모집단위가 동일계열인 자','\"\"','수능 100%로 바로 합격자를 뽑아!',4,'정시','특성화고교');
/*!40000 ALTER TABLE `ksat` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-06-19 13:29:12
