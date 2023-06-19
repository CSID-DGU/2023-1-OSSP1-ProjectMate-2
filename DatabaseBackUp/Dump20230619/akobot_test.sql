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
-- Table structure for table `test`
--

DROP TABLE IF EXISTS `test`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `test` (
  `school_key` int NOT NULL,
  `field` varchar(50) NOT NULL,
  `document` varchar(50) NOT NULL,
  `else_data` varchar(1000) DEFAULT NULL,
  `method` varchar(1000) DEFAULT NULL,
  `target` varchar(1000) DEFAULT NULL,
  `level` int NOT NULL,
  `fname` varchar(45) DEFAULT NULL,
  `dname` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`school_key`,`field`,`document`),
  CONSTRAINT `school-test` FOREIGN KEY (`school_key`) REFERENCES `school` (`school_key`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `test`
--

LOCK TABLES `test` WRITE;
/*!40000 ALTER TABLE `test` DISABLE KEYS */;
INSERT INTO `test` VALUES (11111,'test','test_document','\"\"','국어/ 수학은 수능 성적표의 표준점수, 영어는 우리 대학 기준 환산표적용, 탐구는 수능 성적표에 기재된 2과목의 백분위를 활용한 변환표준점수 활용, 한국사는 수능 등급 활용 감점점수 활용\\\n 영어 환산은 다음과 같다.\\\n 1등급(200) 2등급(199) 3등급(197) 4등급(190) 5등급(180) 6등급(140) 7등급(90) 8등급(20) 9등급(0)','학교생활기록부로 평가하며 2인 이상의 입학사정관이 서류의 내용을 기반으로 하여 충실한 학교생활 바탕의 학업역량, 주도적 학습 태도, 전공관심도, 인성 등을 종합평가\\\n 학교생활충실도 80% 내외 인성 및 사회성 20% 내외로 평가한다.',9,'전형요소별평가방법','서류종합평가'),(11111,'test','test_interview','\"\"','2인의 입학사정관이 제출서류를 바탕으로 10분 내외의 개별면접을 진행하며 서류 내용을 기반으로 발전가능성 20%, 전공 적합성 30%, 전형취지 적합성 20%, 인성 및 사회성 30%를 종합평가\\\n','2인의 입학사정관이 제출서류를 바탕으로 10분 내외의 개별면접을 진행하며 서류 내용을 기반으로 발전가능성 20%, 전공 적합성 30%, 전형취지 적합성 20%, 인성 및 사회성 30%를 종합평가',9,'전형요소별평가방법','면접평가'),(11111,'test','test_records','\"\"','교과는 다음과 같이 반영된다. \\\n 학생부교과전형 인문계열/영화영상학과에서 국어, 수학, 사회, 영어, 한국사, 자연계열에서 국어, 수학, 과학, 영어, 한국사를 석차등급 상위 10과목만 반영\\\n 논술, 실기/실적에서는 국어, 수학, 사회, 과학, 영어, 한국사를 석차등급 상위 10과목만 반영\\\n\\\n 학생부 교과의 경우 1등급(10) 2등급(9.99) 3등급(9.95) 4등급(9.9) 5등급(9.0) 6등급(8.0) 7등급(5.0) 8등급(3.0) 9등급(0.0)\\\n 논술, 실기/실적의 경우 1등급(10) 2등급(9.99) 3등급(9.93) 4등급(9.9) 5등급(9.8) 6등급(8.7) 7등급(7.0) 8등급(6.0) 9등급(5.0)으로 환산후 \\\n  [{sigma(등급점수) / (반영과목수)} / 최대등급점수(10점) x 반영총점] 으로 계산하여 산출한다. \\\n\\\n출결은 다음과 같이 반영된다. \\\n 결석일수」의 미인정ㆍ무단(사고)는 1회당 결석 1일로 반영\\\n - 결과ㆍ지각ㆍ조퇴」의 미인정ㆍ무단(사고)는 3회당 결석 1일로 반영(소숫점 이하는 절사)\\\n - 질병으로 인한 경우에는 반영하지 않음\\\n - 졸업여부와 상관없이 학교생활기록부 상의 전학년 출결을 반영\\\n 결석일수에 따른 환산점수 : 10(3일이하) 9.4(4~6일) 8.8(7~9일) 8.2(10~12일) 7.6(13~15일) 7(16~18일) 6.4(19~21일) 5.8(22일~24일) 5(25일 이상) \\\n\\\n학생부 반영 불가 대상자는 각각 논술과 실기고사 성적에 의한 비교내신 적용','수시의 학생부 교과 전형(학교장 추천인재) 일괄 단계에서 교과 70% 반영\\\n 수시의 학생부 교과 전형(특성화 졸업 재직자(서류형)) 일괄 단계에서 교과 70% 반영 수시의 학생부 교과 전형(특성화 졸업 재직자(면접형)) 1단계에서 교과 100% 반영\\\n 수시의 논술 전형(논술) 일괄 단계에서 교과20% 출결 10% 반영 \\\n 수시의 실기/실적 전형(국어국문ㆍ문예창작학부, 체육교육과,미술학부, 연극학부-특기형, 한국음악과) 일괄단계에서 교과20% 출결 10% 반영 \\\n 수시의 실기/실적 전형(연극학부-실기형, 스포츠문화학과) 2단계에서 교과20% 출결 10% 반영 정시의 학생부 교과 전형(특성화 졸업 재직자) 일괄 단계에서 교과 70% 반영',9,'전형요소별평가방법','학교생활기록부'),(11111,'test','test_SAT','\"\"','국어/ 수학은 수능 성적표의 표준점수, 영어는 우리 대학 기준 환산표적용, 탐구는 수능 성적표에 기재된 2과목의 백분위를 활용한 변환표준점수 활용, 한국사는 수능 등급 활용 감점점수 활용\\\n 영어 환산은 다음과 같다.\\\n 1등급(200) 2등급(199) 3등급(197) 4등급(190) 5등급(180) 6등급(140) 7등급(90) 8등급(20) 9등급(0)','국어/ 수학은 수능 성적표의 표준점수, 영어는 우리 대학 기준 환산표적용, 탐구는 수능 성적표에 기재된 2과목의 백분위를 활용한 변환표준점수 활용, 한국사는 수능 등급 활용 감점점수 활용\\\n 영어 환산은 다음과 같다.\\\n 1등급(200) 2등급(199) 3등급(197) 4등급(190) 5등급(180) 6등급(140) 7등급(90) 8등급(20) 9등급(0)',9,'전형요소별평가방법','대학수학능력시험'),(11111,'test','test_test','아래에서 궁금한 평가방법을 말해줘!\\n[서류종합 평가], [면접 평가], [학교생활기록부], [대학수학능력시험]','','',1,'전형요소별평가방법','전형요소별평가방법');
/*!40000 ALTER TABLE `test` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-06-19 13:29:11
