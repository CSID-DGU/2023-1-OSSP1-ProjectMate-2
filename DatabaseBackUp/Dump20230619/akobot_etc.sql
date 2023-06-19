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
-- Table structure for table `etc`
--

DROP TABLE IF EXISTS `etc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `etc` (
  `school_key` int NOT NULL,
  `field` varchar(50) NOT NULL,
  `document` varchar(50) NOT NULL,
  `else_data` varchar(1000) DEFAULT NULL,
  `content` varchar(1000) DEFAULT NULL,
  `level` int NOT NULL,
  `fname` varchar(45) DEFAULT NULL,
  `dname` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`school_key`,`field`,`document`),
  CONSTRAINT `school-etc` FOREIGN KEY (`school_key`) REFERENCES `school` (`school_key`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `etc`
--

LOCK TABLES `etc` WRITE;
/*!40000 ALTER TABLE `etc` DISABLE KEYS */;
INSERT INTO `etc` VALUES (11111,'competition','competition_competition','수시, 정시 중에서 뭐가 궁금해?','',1,'작년도경쟁률','작년도경쟁률'),(11111,'competition','competition_earlyadmission','\"\"','http://addon.jinhakapply.com/RatioV1/RatioH/Ratio10550261.html',6,'작년도경쟁률','수시경쟁률'),(11111,'competition','competition_ksat','\"\"','http://addon.jinhakapply.com/RatioV1/RatioH/Ratio10550241.html',6,'작년도경쟁률','정시경쟁률'),(11111,'fallback','fallback_default','\"\"','',11,'잘못된 입력','잘못된 입력'),(11111,'foreign','foreign_foreign','\"\"','재외국민 전형에서는 재외국민과 12년 해외 전교육과정 이수자 및 새터민인 경우 해당하고 인문계열/영화영상학과에서는 1단계 국어 50%, 영어 50%로 6배수를 뽑고 2단계에서는 1단계 성적으로 지원자격심사릃 진행해. 그리고 자연계열에서는 1단계 영어 50%, 수학 50%로 6배수를 뽑고 2단계에서는 1단계 성적으로 지원자격심사를 진행해. 외국인 전형은 부모 모두 외국인인 경우에 대항하고 인문/자연/예능(영화영상)에서는 서류종합평가 100%, 예능(미술/연극)에서는 실기구술 100%로 뽑아',1,'외국인특별전형','외국인특별전형'),(11111,'note','note_farming','\"\"','https://drive.google.com/file/d/12iSGvGhQEjTwmMXxvkFz4bjJt91hBPP-/view?usp=sharing',7,'지원자격유의사항','농어촌학생재학거주인정기준'),(11111,'note','note_incumbent','\"\"','https://drive.google.com/file/d/1TqJG7vaf7W2s_zKQMf-SVCzrC0lweeq8/view?usp=sharing',7,'지원자격유의사항','재직기간산정기준'),(11111,'note','note_note','아래에서 궁금한 것을 말해줘!\\n[농어촌학생 재학 거주 인정기준], [특성화고교 동일계열 기준학과], [재직기간 산정기준]','',1,'지원자격유의사항','지원자격유의사항'),(11111,'note','note_special','\"\"','https://drive.google.com/file/d/14GPTtDOS53p9I_Za0rOEJLxCJF8kmjND/view?usp=sharing',7,'지원자격유의사항','특성화고교졸업자동일계열기준학과'),(11111,'recruit','recruit_recruit','\"\"','https://drive.google.com/file/d/1uPzcfZ4xu29cUXBLZDSMP2dv8pnp25zj/view?usp=sharing',1,'모집인원','모집인원'),(11111,'schedule','schedule_earlyadmission','\"\"','https://drive.google.com/file/d/1aEO8CJNEKbZgPGgGuXJBdKOGGJFPzn0t/view?usp=sharing',10,'전형일정','수시일정'),(11111,'schedule','schedule_foreigner','\"\"','https://drive.google.com/file/d/1aEO8CJNEKbZgPGgGuXJBdKOGGJFPzn0t/view?usp=sharing',10,'전형일정','재외국민/외국인일정'),(11111,'schedule','schedule_ksat','\"\"','https://drive.google.com/file/d/1aEO8CJNEKbZgPGgGuXJBdKOGGJFPzn0t/view?usp=sharing',10,'전형일정','정시일정'),(11111,'total','total_total','\"\"','https://drive.google.com/file/d/1uv57JfULCoU4DtWPyS0xvdJtfxK6OR_e/view?usp=sharing',1,'전체모집요강','전체모집요강');
/*!40000 ALTER TABLE `etc` ENABLE KEYS */;
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
