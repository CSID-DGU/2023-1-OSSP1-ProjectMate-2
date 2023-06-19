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
-- Table structure for table `earlyadmission`
--

DROP TABLE IF EXISTS `earlyadmission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `earlyadmission` (
  `school_key` int NOT NULL,
  `field` varchar(50) NOT NULL,
  `document` varchar(50) NOT NULL,
  `condition_text` varchar(2000) DEFAULT NULL,
  `else_data` varchar(2000) DEFAULT NULL,
  `point` varchar(2000) DEFAULT NULL,
  `test` varchar(2000) DEFAULT NULL,
  `level` int NOT NULL,
  `fname` varchar(45) DEFAULT NULL,
  `dname` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`school_key`,`field`,`document`),
  CONSTRAINT `school_susi` FOREIGN KEY (`school_key`) REFERENCES `school` (`school_key`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `earlyadmission`
--

LOCK TABLES `earlyadmission` WRITE;
/*!40000 ALTER TABLE `earlyadmission` DISABLE KEYS */;
INSERT INTO `earlyadmission` VALUES (11111,'earlyadmission','earlyadmission_buddhism','국내/외 고교 졸업(예정)자 또는 법령에 의하여 이와 동등 이상의 학력이 있다고 인정되는 자(외국 검정고시 합격자 제외) 일반학과는 대한불교 조계종 산하 사찰(포교당 포함) 주지스님 혹은 소속(졸업) 종립고등학교장의 추천을 받은 자 불교학과와 문화재학과는 대한불교조계종 재적 승려(2023년 9월 및 2024년 3월 승적 취득예정자 지원 가능)','\"\"','1단계 에서는 2/3배수 인원을 서류종합평가 100%로 뽑고, 2단계에서는 1단계 성적의 70%와 면접 30%로 합격자를 뽑아.','수능 최저 학력기준은 적용하지 않아!',3,'수시','불교추천'),(11111,'earlyadmission','earlyadmission_dodream\n ','국내/외 고교 졸업(예정)자 또는 법령에 의하여 이와 동등 이상의 학력이 있다고 인정되는 자(외국 검정고시 합격자 제외)','\"\"','1단계 에서는 3.5/4배수 인원을 서류종합평가 100%로 뽑고, 2단계에서는 1단계 성적의 70%와 면접 30%로 합격자를 뽑아.','수능 최저 학력기준은 적용하지 않아!',3,'수시','두드림'),(11111,'earlyadmission','earlyadmission_dodreamsoft\n ','국내/외 고교 졸업(예정)자 또는 법령에 의하여 이와 동등 이상의 학력이 있다고 인정되는 자(외국 검정고시 합격자 제외)','\"\"','1단계에서는 2.5배수 인원을 서류종합평가 100%로 뽑고, 2단계에서는 1단계 성적의 70%와 면접 평가 30%로 합격자를 뽑아.','수능 최저 학력기준은 적용하지 않아!',3,'수시','두드림소프트웨어'),(11111,'earlyadmission','earlyadmission_earlyadmission','','아래 전형 중에서 무슨 전형이 궁금한지 말해줘!\\n[두드림] , [두드림소프트웨어] , [불교추천인재] , [고른기회통합] , [특수교육대상자] , [재직자] , [학교장추천인재] , [논술] , [실기]','','',1,'수시','수시'),(11111,'earlyadmission','earlyadmission_essay','국내/외 고교 졸업(예정)자 또는 법령에 의하여 이와 동등 이상의 학력이 있다고 인정되는자(외국 검정고시 합격자 제외)로서\\n 우리대학이 요구하는 해당연도 대학수학능력시험 최저학력기준을 갖춘 자','\"\"','학생부교과 20%, 출결 10%, 논술 70%로 바로 합격자를 뽑아.','수능 최저 학력기준을 적용해! 인문계열 : 국어/수학/영어/탐구 중 2개 영역 등급 합 5 이내, 한국사 4등급 이내 경찰행정학부(인문/자연) : 국어/수학/영어/탐구 중 2개 영역 등급 합 4 이내, 한국사 4등급 이내 자연계열 : 국어/수학/영어/과학탐구 중 2개 영역 등급 합 5 이내, 한국사 4등급 이내 (단, 등급 합 산정 시 수학 또는 과학탐구 1개 이상 포함) 약학과 : 국어/수학/영어/과학탐구 중 3개 영역 등급 합 4 이내, 한국사 4등급 이내 (단, 등급 합 산정 시 수학 또는 과학탐구 1개 이상 포함) AI소프트웨어융합학부(인문): 국어/수학/영어/탐구 중 2개 영역 등급 합 5 이내, 한국사 4등급 이내 (단, 등급 합 산정 시 수학 포함) AI소프트웨어융합학부(자연): 국어/수학/영어/과학탐구 중 2개 영역 등급 합 5 이내, 한국사 4등급 이내 (단, 등급 합 산정 시 수학 포함) 국어 및 수학영역 선택과목 지정은 없고, 탐구 영역은 2개 과목중 상위 1개만 반영해!',3,'수시','논술'),(11111,'earlyadmission','earlyadmission_incumbent','아래 중 하나에 해당하는 자로서 산업체 근무경력이 통산 3년 이상인 재직자 \\n 초/중등교육법시행령 제76조의3제1호에 따른 일반고등학교에서 재학하는 동안 시도 교육감이 직업교육훈련 촉진법에 따른 직업교육훈련기관 중 직업교육훈련 위탁기관으로 선정한 기관에서 1년이상의 직업교육훈련과정을 이수하고 해당 일반고등학교를 졸업한 자\\n초/중등교육법시행령 제90조제1항제10호에 따른 산업수요 맞춤형 고등학교를 졸업한 자\\n특성화고등학교 등을 졸업한 자(단, 종합고 “보통과” 졸업자는 지원 불가)\\n 평생교육법 제31조제2항에 따른 학력인정 평생교육시설 중 특성화고등학교 등에서 제공하는 것과같은 교육과정을 운영하는 평생교육시설에서 해당 교육과정을 이수한 자','\"\"','서류형은 학생부교과 70%와 서류종합평가 30%로 합격자를 뽑아. 면접형은 1단계에서 2.5배수를 학생부교과 100%로 선발하고 2단계에서는 면접 30%와 1단계 성적 70%로 합격자를 뽑아.','수능 최저 학력 기준은 적용하지 않아!',3,'수시','재직자'),(11111,'earlyadmission','earlyadmission_performance','국내/외 고교 졸업(예정)자 또는 법령에 의하여 이와 동등 이상의 학력이 있다고 인정되는 자(외국 검정고시 합격자 제외) \\n연극학부 특기형은 다음 어느 하나 이상의 실적이 있는 자여야 해. \\n 유형1: 연극, 뮤지컬, 영화, 방송 관련 분야 주 조연급 경력자(CF포함) \\n 유형2: 공식음반을 발표하고 방송 가요 프로그램 출연 경력이 있는 자 \\n 유형3: 기타 연극, 뮤지컬, 영화, 방송 관련 분야에서 활동 중인 자로서 우리 대학 실적심사 위원회에서 인정할 만한 경력이 있는 자','\"\"','전형방법 및 실기고사 내용이 학부별로 다양해! (국어국문 문예창작부, 체육교육과, 미술학부, 한국음악과, 연극학부-실기형, 연극학부-특기형, 스포츠문화학과','수능 최저 학력 기준은 적용하지 않아!',3,'수시','실기'),(11111,'earlyadmission','earlyadmission_principal','국내 고교 졸업(예정)자로서 소속(졸업) 고등학교장의 추천을 받은 자이며\\n 고교 추천인원 : 8명 이내\\n 원서접수 마감일 기준 3학기 이상의 교육과정을 이수하고 본교 학생부 반영 교과목 석차 등급이 10과목 이상 기재되어 있는 자\\n 학력인정 평생교육시설, 각종학교, 방송통신고, 고등기술학교 등 법령에 의한 학력인정 학교, 교육부 인가 재외한국학교 또는 유사한 교육기관 등의 졸업(예정)자는 지원 불가','\"\"','학생부 교과 70%, 서류종합평가 30%로 바로 합격자를 뽑아.','수능 최저 학력 기준은 적용하지 않아!',3,'수시','학교장추천'),(11111,'earlyadmission','earlyadmission_regular','국가보훈 대상자는 국내/외 고교 졸업(예정)자 또는 법령에 의하여 이와 동등 이상의 학력이 있다고 인정되는 자로서, 국가보훈 기본법 제3조 제2호의 \'국가보훈대상자\'로서 국가보훈 관계 법령에 따른 교육지원 대상자\\n 농어촌학생은 농어촌 지역 또는 도서/벽지 교육진흥법 제2조에 따른 도서/벽지의 고등학교 졸업(예정)자로서 유형 2가지중 하나에 해당하는자 \\n 유형 1: 농어촌지역 중/고등학교에서 중학교 입학일부터 고등학교 졸업(예정)일까지 전 교육과정을 연속으로 이수(예정)하고, 6년 동안 부/모/학생 모두가 농어촌지역에 거주한 자 \\n 유형 2: 농어촌지역 초/중/고등학교에서 초등학교 입학일부터 고등학교 졸업(예정)일까지 전 교육과정을 연속으로 이수(예정)하고, 12년 동안 학생이 농어촌지역에 거주한 자 특성화고교 졸업자는 특성화고등학교 졸업(예정)자로서 고교 이수 과와 우리대학 지원 모집단위가 동일계열인 자\\n 기초생활 수급자 및 차상위계층은 국내/외 고교 졸업(예정)자 또는 법령에 의하여 이와 동등 이상의 학력이 있다고 인정되는 자로서 원서 마감일 기준 아래 중 하나에 해당하는 자 \\n 국민기초생활보장법 제2조 제1호에 따른 수급권자 \\n 국민기초생활보장법 제2조 제10호에 따른 차상위계층 \\n 한부모가족지원법 제5조 및 제5조의2에 따른 지원 대상자 \\n 서해5도 학생은 \'서해5도 지원 특별법\' 제 15조 및 \'서해5도 지원 특별법 시행령\' 제 11조에 따라 서해5도에 설립된 고등학교 졸업 (예정)자로서, 다음의 유형 중 하나에 해당하는 자 \\n 유형 1: 서해5도에 설립된 중고등학교에서 중학교 입학일로부터 고등학교 졸업(예정)일까지 전교육과정을 이수(예정)하고, 6년 동안 부, 모, 학생 모두가 <서해5도>에 거주한 자 \\n 유형 2: 서해5도에 설립된 초중고등학교에서 초등학교 입학일로부터 고등학교 졸업 (예정)일까지 전 교육과정을 이수(예정)하고, 12년 동안 학생이 서해5도에 거주한 자 자립지원대상자는 국내/외 고교 졸업(예정)자 또는 법령에 의하여 이와 동등 이상의 학력이 있다고 인정되는 자로서, 원서 접수 마감일 기준, 다음의 아동복지법 시행령 제 38조 제 2항에 해당하는 자 \\n 유형 1: 대리양육 또는 가정위탁보호 중인 아동 \\n 유형 2: 아동복지시설에서 보호 중인 아동 \\n 유형 3: 아동복지법 제 16조에 따라 보호조치가 종료되거나 해당 시설에서 퇴소한 지 5년이 지나지 않은 아동','\"\"','1단계에서는 5배수 인원을 서류종합평가 100%로 뽑고, 2단계에서는 1단계성적의 70%와 면접 평가 30%로 합격자를 뽑아.','수능 최저 학력기준은 적용하지 않아!',3,'수시','고른기회'),(11111,'earlyadmission','earlyadmission_special','국내/외 고교 졸업(예정)자 또는 법령에 의하여 이와 동등 이상의 학력이 있다고 인정되는 자(외국 검정고시 합격자 제외)로서 원서 접수 마감일 기준 아래 중 하나에 해당하는 자','\"\"','1단계에서는 5배수 인원을 서류종합평가 100%로 뽑고, 2단계에서는 1단계성적의 70%와 면접 평가 30%로 합격자를 뽑아.','수능 최저 학력 기준은 적용하지 않아!',3,'수시','특수교육대상자');
/*!40000 ALTER TABLE `earlyadmission` ENABLE KEYS */;
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
