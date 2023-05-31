-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: localhost    Database: akobot
-- ------------------------------------------------------
-- Server version	8.0.33

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
-- Table structure for table `susi`
--

DROP TABLE IF EXISTS `susi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `susi` (
  `school_key` int NOT NULL,
  `field` varchar(50) NOT NULL,
  `document` varchar(50) NOT NULL,
  `condition_text` varchar(2000) DEFAULT NULL,
  `elseData` varchar(2000) DEFAULT NULL,
  `point` varchar(2000) DEFAULT NULL,
  `test` varchar(2000) DEFAULT NULL,
  `level` int NOT NULL,
  `else_data` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`school_key`,`field`,`document`),
  CONSTRAINT `school_susi` FOREIGN KEY (`school_key`) REFERENCES `school` (`school_key`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `susi`
--

LOCK TABLES `susi` WRITE;
/*!40000 ALTER TABLE `susi` DISABLE KEYS */;
INSERT INTO `susi` VALUES (11111,'susi','susi_buddhism','국내/외 고교 졸업(예정)자 또는 법령에 의하여 이와 동등 이상의 학력이 있다고 인정되는 자(외국 검정고시 합격자 제외) 일반학과는 대한불교 조계종 산하 사찰(포교당 포함) 주지스님 혹은 소속(졸업) 종립고등학교장의 추천을 받은 자 불교학과와 문화재학과는 대한불교조계종 재적 승려(2023년 9월 및 2024년 3월 승적 취득예정자 지원 가능)','','1단계 에서는 2/3배수 인원을 서류종합평가 100%로 뽑고, 2단계에서는 1단계 성적의 70%와 면접 30%로 합격자를 뽑아.','수능 최저 학력기준은 적용하지 않아!',3,NULL),(11111,'susi','susi_dodream\n','국내/외 고교 졸업(예정)자 또는 법령에 의하여 이와 동등 이상의 학력이 있다고 인정되는 자(외국 검정고시 합격자 제외)','\"\"','1단계 에서는 3.5/4배수 인원을 서류종합평가 100%로 뽑고, 2단계에서는 1단계 성적의 70%와 면접 30%로 합격자를 뽑아.','수능 최저 학력기준은 적용하지 않아!',3,NULL),(11111,'susi','susi_dodreamsoft\n','국내/외 고교 졸업(예정)자 또는 법령에 의하여 이와 동등 이상의 학력이 있다고 인정되는 자(외국 검정고시 합격자 제외)','\"\"','1단계에서는 2.5배수 인원을 서류종합평가 100%로 뽑고, 2단계에서는 1단계 성적의 70%와 면접 평가 30%로 합격자를 뽑아.','수능 최저 학력기준은 적용하지 않아!',3,NULL),(11111,'susi','susi_essay','국내ㆍ외 고교 졸업(예정)자 또는 법령에 의하여 이와 동등 이상의 학력이 있다고 인정되는자(외국 검정고시 합격자 제외)로서 우리대학이 요구하는 해당연도 대학수학능력시험 최저학력기준을 갖춘 자','','학생부교과 20%, 출결 10%, 논술 70%로 바로 합격자를 뽑아.','수능 최저 학력기준을 적용해! 인문계열 : 국어/수학/영어/탐구 중 2개 영역 등급 합 5 이내, 한국사 4등급 이내 경찰행정학부(인문/자연) : 국어/수학/영어/탐구 중 2개 영역 등급 합 4 이내, 한국사 4등급 이내 자연계열 : 국어/수학/영어/과학탐구 중 2개 영역 등급 합 5 이내, 한국사 4등급 이내 (단, 등급 합 산정 시 수학 또는 과학탐구 1개 이상 포함) 약학과 : 국어/수학/영어/과학탐구 중 3개 영역 등급 합 4 이내, 한국사 4등급 이내 (단, 등급 합 산정 시 수학 또는 과학탐구 1개 이상 포함) AI소프트웨어융합학부(인문): 국어/수학/영어/탐구 중 2개 영역 등급 합 5 이내, 한국사 4등급 이내 (단, 등급 합 산정 시 수학 포함) AI소프트웨어융합학부(자연): 국어/수학/영어/과학탐구 중 2개 영역 등급 합 5 이내, 한국사 4등급 이내 (단, 등급 합 산정 시 수학 포함) 국어 및 수학영역 선택과목 지정은 없고, 탐구 영역은 2개 과목중 상위 1개만 반영해!',3,NULL),(11111,'susi','susi_incumbent','아래 중 하나에 해당하는 자로서 산업체 근무경력이 통산 3년 이상인 재직자','','서류형은 학생부교과 70%와 서류종합평가 30%로 합격자를 뽑아. 면접형은 1단계에서 2.5배수를 학생부교과 100%로 선발하고 2단계에서는 면접 30%와 1단계 성적 70%로 합격자를 뽑아.','수능 최저 학력 기준은 적용하지 않아!',3,NULL),(11111,'susi','susi_principal','국내 고교 졸업(예정)자로서 소속(졸업) 고등학교장의 추천을 받은 자이며','\"\"','학생부 교과 70%, 서류종합평가 30%로 바로 합격자를 뽑아.','수능 최저 학력 기준은 적용하지 않아!',3,NULL),(11111,'susi','susi_special','국내ㆍ외 고교 졸업(예정)자 또는 법령에 의하여 이와 동등 이상의 학력이 있다고 인정되는 자(외국 검정고시 합격자 제외)로서 원서 접수 마감일 기준 아래 중 하나에 해당하는 자','\"\"','1단계에서는 5배수 인원을 서류종합평가 100%로 뽑고, 2단계에서는 1단계성적의 70%와 면접 평가 30%로 합격자를 뽑아.','수능 최저 학력 기준은 적용하지 않아!',3,NULL);
/*!40000 ALTER TABLE `susi` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-05-31 23:26:25
