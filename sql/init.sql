-- -------------------------------------------------------------
-- TablePlus 3.12.0(354)
--
-- https://tableplus.com/
--
-- Database: insurance_portal
-- Generation Time: 2020-12-28 17:42:14.9090
-- -------------------------------------------------------------


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


CREATE TABLE `article` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `deleted_at` datetime(6) DEFAULT NULL,
  `is_active` bit(1) DEFAULT NULL,
  `is_deleted` bit(1) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  `article_image` varchar(255) DEFAULT NULL,
  `content` longtext NOT NULL,
  `post_date` datetime(6) NOT NULL,
  `short_description` varchar(255) DEFAULT NULL,
  `title` varchar(255) NOT NULL,
  `article_category_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKiu3gnbl8tvk86o04rnm0jr0py` (`article_category_id`),
  CONSTRAINT `FKiu3gnbl8tvk86o04rnm0jr0py` FOREIGN KEY (`article_category_id`) REFERENCES `article_category` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `article_category` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `deleted_at` datetime(6) DEFAULT NULL,
  `is_active` bit(1) DEFAULT NULL,
  `is_deleted` bit(1) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `short_description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `authorities` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `code` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `is_active` bit(1) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `authorities_group_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_o3dg4dkhlj82n0iv1i09ubtpt` (`code`),
  UNIQUE KEY `UK_nb3atvjf9ov5d0egnuk47o5e` (`name`),
  KEY `FKcqalxpmmyfpmdk0ims8ruj169` (`authorities_group_id`),
  CONSTRAINT `FKcqalxpmmyfpmdk0ims8ruj169` FOREIGN KEY (`authorities_group_id`) REFERENCES `authorities_group` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `authorities_group` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `deleted_at` datetime(6) DEFAULT NULL,
  `is_active` bit(1) DEFAULT NULL,
  `is_deleted` bit(1) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `parent_authorities_group_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKlb5uak37b0r226r1frh39w1et` (`parent_authorities_group_id`),
  CONSTRAINT `FKlb5uak37b0r226r1frh39w1et` FOREIGN KEY (`parent_authorities_group_id`) REFERENCES `authorities_group` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `benefit` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `deleted_at` datetime(6) DEFAULT NULL,
  `is_active` bit(1) DEFAULT NULL,
  `is_deleted` bit(1) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `is_benefit_plus` bit(1) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `parent_id` varchar(255) DEFAULT NULL,
  `product_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK8a9nc8kw3adr38tirolk9pn7j` (`product_id`),
  CONSTRAINT `FK8a9nc8kw3adr38tirolk9pn7j` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `benefit_setting` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `deleted_at` datetime(6) DEFAULT NULL,
  `is_active` bit(1) DEFAULT NULL,
  `is_deleted` bit(1) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `benefit_id` bigint DEFAULT NULL,
  `product_pack_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK7ap94452yc5go7mev7xl06ive` (`benefit_id`),
  KEY `FK4oqu8fhkxc20tx4hq6co23hvt` (`product_pack_id`),
  CONSTRAINT `FK4oqu8fhkxc20tx4hq6co23hvt` FOREIGN KEY (`product_pack_id`) REFERENCES `product_pack` (`id`),
  CONSTRAINT `FK7ap94452yc5go7mev7xl06ive` FOREIGN KEY (`benefit_id`) REFERENCES `benefit` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `customer` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `deleted_at` datetime(6) DEFAULT NULL,
  `is_active` bit(1) DEFAULT NULL,
  `is_deleted` bit(1) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  `customer_code` varchar(255) DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKj8dlm21j202cadsbfkoem0s58` (`user_id`),
  CONSTRAINT `FKj8dlm21j202cadsbfkoem0s58` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `customer_contact_code` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `deleted_at` datetime(6) DEFAULT NULL,
  `is_active` bit(1) DEFAULT NULL,
  `is_deleted` bit(1) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  `contact_code` varchar(255) DEFAULT NULL,
  `customer_id` bigint DEFAULT NULL,
  `product_provider_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK2cltgx4vhyyhahjg1heax1gft` (`customer_id`),
  KEY `FKa4ecti6kft7gp34v7jfnp78wk` (`product_provider_id`),
  CONSTRAINT `FK2cltgx4vhyyhahjg1heax1gft` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`),
  CONSTRAINT `FKa4ecti6kft7gp34v7jfnp78wk` FOREIGN KEY (`product_provider_id`) REFERENCES `product_provider` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `district` (
  `code` bigint NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `deleted_at` datetime(6) DEFAULT NULL,
  `is_active` bit(1) DEFAULT NULL,
  `is_deleted` bit(1) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `province_code` bigint DEFAULT NULL,
  PRIMARY KEY (`code`),
  KEY `FK79l51ggj1wv1opcs6dkcy8c98` (`province_code`),
  CONSTRAINT `FK79l51ggj1wv1opcs6dkcy8c98` FOREIGN KEY (`province_code`) REFERENCES `province` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `faq` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `deleted_at` datetime(6) DEFAULT NULL,
  `is_active` bit(1) DEFAULT NULL,
  `is_deleted` bit(1) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  `content` longtext,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `order` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `deleted_at` datetime(6) DEFAULT NULL,
  `is_active` bit(1) DEFAULT NULL,
  `is_deleted` bit(1) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  `customer_code` varchar(255) NOT NULL,
  `fee_amount` double DEFAULT NULL,
  `beneficiarydob` datetime(6) DEFAULT NULL,
  `beneficiary_email` varchar(255) DEFAULT NULL,
  `beneficiary_full_name` varchar(255) DEFAULT NULL,
  `beneficiary_gender` varchar(255) DEFAULT NULL,
  `beneficiary_phone_number` varchar(255) DEFAULT NULL,
  `beneficiary_relationship` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `effective_date` datetime(6) NOT NULL,
  `expired_date` datetime(6) NOT NULL,
  `insured_address` varchar(255) DEFAULT NULL,
  `insureddob` varchar(255) DEFAULT NULL,
  `insured_email` varchar(255) DEFAULT NULL,
  `insured_full_name` varchar(255) DEFAULT NULL,
  `insured_gender` varchar(255) DEFAULT NULL,
  `insured_id_number` varchar(255) DEFAULT NULL,
  `order_status` int NOT NULL,
  `proposal_num` varchar(255) DEFAULT NULL,
  `customer_id` bigint DEFAULT NULL,
  `product_pack_detail_id` bigint DEFAULT NULL,
  `promo_code_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1oduxyuuo3n2g98l3j7754vym` (`customer_id`),
  KEY `FKkdsx4fagbrt2rse3l0w9443d3` (`product_pack_detail_id`),
  KEY `FKb705w3g63oi4gfd1aff293f84` (`promo_code_id`),
  CONSTRAINT `FK1oduxyuuo3n2g98l3j7754vym` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`),
  CONSTRAINT `FKb705w3g63oi4gfd1aff293f84` FOREIGN KEY (`promo_code_id`) REFERENCES `promo_code` (`id`),
  CONSTRAINT `FKkdsx4fagbrt2rse3l0w9443d3` FOREIGN KEY (`product_pack_detail_id`) REFERENCES `product_pack_detail` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `order_attribute_setting` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `deleted_at` datetime(6) DEFAULT NULL,
  `is_active` bit(1) DEFAULT NULL,
  `is_deleted` bit(1) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  `order_id` bigint DEFAULT NULL,
  `product_attribute_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKip5ardq4g5r2c8aj6qxjnev30` (`order_id`),
  KEY `FKh5nadrxvgn4qaxisla7rr8lu1` (`product_attribute_id`),
  CONSTRAINT `FKh5nadrxvgn4qaxisla7rr8lu1` FOREIGN KEY (`product_attribute_id`) REFERENCES `product_attribute` (`id`),
  CONSTRAINT `FKip5ardq4g5r2c8aj6qxjnev30` FOREIGN KEY (`order_id`) REFERENCES `order` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `payment_method` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `deleted_at` datetime(6) DEFAULT NULL,
  `is_active` bit(1) DEFAULT NULL,
  `is_deleted` bit(1) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  `code` int DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `policy` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `deleted_at` datetime(6) DEFAULT NULL,
  `is_active` bit(1) DEFAULT NULL,
  `is_deleted` bit(1) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  `active_date` datetime(6) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `auto_extend_expired_date` datetime(6) DEFAULT NULL,
  `auto_extend_fee_amount` double DEFAULT NULL,
  `bidaily_payment_attempts` int DEFAULT NULL,
  `buyer_id_number` varchar(255) DEFAULT NULL,
  `cancel_date` datetime(6) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `contact_no` varchar(255) DEFAULT NULL,
  `created_policy_date` datetime(6) DEFAULT NULL,
  `customer_code` varchar(255) NOT NULL,
  `daily_extend_attempt` int DEFAULT NULL,
  `dob` datetime(6) DEFAULT NULL,
  `effective_date` datetime(6) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `enable_extend` bit(1) NOT NULL,
  `expired_date` datetime(6) NOT NULL,
  `extend_success_date` datetime(6) DEFAULT NULL,
  `fee_amount` double NOT NULL,
  `full_name` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `id_number` varchar(255) DEFAULT NULL,
  `last_auto_extend_attempt_date` datetime(6) DEFAULT NULL,
  `next_debt_date` datetime(6) DEFAULT NULL,
  `paid_amount` double DEFAULT NULL,
  `paid_amount_percentage` double DEFAULT NULL,
  `payment_status` int NOT NULL,
  `policy_group` int DEFAULT NULL,
  `promo_code` varchar(255) DEFAULT NULL,
  `purchase_method` int NOT NULL,
  `status` int NOT NULL,
  `sync_cancel_policy` bit(1) DEFAULT NULL,
  `sync_policy` bit(1) DEFAULT NULL,
  `customer_id` bigint DEFAULT NULL,
  `order_id` bigint DEFAULT NULL,
  `payment_method_id` bigint DEFAULT NULL,
  `product_pack_detail_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK2vl1pwd258e41jnam1cnc3vna` (`customer_id`),
  KEY `FK6jgtv7o3pd0boap58hbsijep8` (`order_id`),
  KEY `FKdew10c2i6ipo41eajktofybl9` (`payment_method_id`),
  KEY `FKensifuv8mf9p8d7iaum3tc2fp` (`product_pack_detail_id`),
  CONSTRAINT `FK2vl1pwd258e41jnam1cnc3vna` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`),
  CONSTRAINT `FK6jgtv7o3pd0boap58hbsijep8` FOREIGN KEY (`order_id`) REFERENCES `order` (`id`),
  CONSTRAINT `FKdew10c2i6ipo41eajktofybl9` FOREIGN KEY (`payment_method_id`) REFERENCES `payment_method` (`id`),
  CONSTRAINT `FKensifuv8mf9p8d7iaum3tc2fp` FOREIGN KEY (`product_pack_detail_id`) REFERENCES `product_pack_detail` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `product` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `deleted_at` datetime(6) DEFAULT NULL,
  `is_active` bit(1) DEFAULT NULL,
  `is_deleted` bit(1) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  `effective_date_range_selection_number` int DEFAULT NULL,
  `avatar_image` varchar(255) DEFAULT NULL,
  `banner_image` varchar(255) DEFAULT NULL,
  `can_buy_multiple` bit(1) DEFAULT NULL,
  `code` varchar(255) NOT NULL,
  `detailed_description` longtext NOT NULL,
  `duplicate_buyer_info` bit(1) DEFAULT NULL,
  `effective_date_type` varchar(255) NOT NULL,
  `enable_indemnity` bit(1) DEFAULT NULL,
  `fee_type` varchar(255) NOT NULL,
  `gender_apply` varchar(255) NOT NULL,
  `hide_beneficiary` bit(1) DEFAULT NULL,
  `hide_buyer_info` bit(1) DEFAULT NULL,
  `indemnity_instruction` varchar(255) DEFAULT NULL,
  `indemnity_instruction_content` longtext NOT NULL,
  `indemnity_template` varchar(255) DEFAULT NULL,
  `is_self_insurance` bit(1) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `price_obj` varchar(255) DEFAULT NULL,
  `product_status` int NOT NULL,
  `short_description` longtext NOT NULL,
  `video_url` varchar(255) DEFAULT NULL,
  `product_category_id` bigint DEFAULT NULL,
  `product_provider_id` bigint DEFAULT NULL,
  `target_group_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKcwclrqu392y86y0pmyrsi649r` (`product_category_id`),
  KEY `FKel7xdro2dm8pm69byl4jpdfa5` (`product_provider_id`),
  KEY `FKal990foc7b0tlcxducc0u126l` (`target_group_id`),
  CONSTRAINT `FKal990foc7b0tlcxducc0u126l` FOREIGN KEY (`target_group_id`) REFERENCES `target_group` (`id`),
  CONSTRAINT `FKcwclrqu392y86y0pmyrsi649r` FOREIGN KEY (`product_category_id`) REFERENCES `product_category` (`id`),
  CONSTRAINT `FKel7xdro2dm8pm69byl4jpdfa5` FOREIGN KEY (`product_provider_id`) REFERENCES `product_provider` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `product_attribute` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `deleted_at` datetime(6) DEFAULT NULL,
  `is_active` bit(1) DEFAULT NULL,
  `is_deleted` bit(1) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  `padding_by_parent` bit(1) DEFAULT NULL,
  `active` bit(1) NOT NULL,
  `applied_to_all_product_provider` bit(1) NOT NULL,
  `attribute_format` int NOT NULL,
  `attribute_group` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `contains` varchar(255) DEFAULT NULL,
  `display_onfe` bit(1) NOT NULL,
  `format_object` varchar(255) DEFAULT NULL,
  `is_parent` bit(1) DEFAULT NULL,
  `max_value_date` datetime(6) DEFAULT NULL,
  `max_value_text` int DEFAULT NULL,
  `min_value_date` datetime(6) DEFAULT NULL,
  `min_value_text` int DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `show_hide_by_parent` bit(1) DEFAULT NULL,
  `parent_id` bigint DEFAULT NULL,
  `product_provider_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKig7jke7667adwnbu5n1gj9mhu` (`parent_id`),
  KEY `FKm0kixpomnjun78k69k4qvgjnm` (`product_provider_id`),
  CONSTRAINT `FKig7jke7667adwnbu5n1gj9mhu` FOREIGN KEY (`parent_id`) REFERENCES `product_attribute` (`id`),
  CONSTRAINT `FKm0kixpomnjun78k69k4qvgjnm` FOREIGN KEY (`product_provider_id`) REFERENCES `product_provider` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `product_attribute_option` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `deleted_at` datetime(6) DEFAULT NULL,
  `is_active` bit(1) DEFAULT NULL,
  `is_deleted` bit(1) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  `value` varchar(255) DEFAULT NULL,
  `product_attribute_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKrlb3yw5ivmkt31ae5a617mryv` (`product_attribute_id`),
  CONSTRAINT `FKrlb3yw5ivmkt31ae5a617mryv` FOREIGN KEY (`product_attribute_id`) REFERENCES `product_attribute` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `product_attribute_setting` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `deleted_at` datetime(6) DEFAULT NULL,
  `is_active` bit(1) DEFAULT NULL,
  `is_deleted` bit(1) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  `product_id` bigint DEFAULT NULL,
  `product_attribute_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1w9jekwhxd9v5ayfw9sx3oq5f` (`product_id`),
  KEY `FKjw957b38xmvg4c5o7665d5uop` (`product_attribute_id`),
  CONSTRAINT `FK1w9jekwhxd9v5ayfw9sx3oq5f` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`),
  CONSTRAINT `FKjw957b38xmvg4c5o7665d5uop` FOREIGN KEY (`product_attribute_id`) REFERENCES `product_attribute` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `product_category` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `deleted_at` datetime(6) DEFAULT NULL,
  `is_active` bit(1) DEFAULT NULL,
  `is_deleted` bit(1) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `name_display_on_client` varchar(255) DEFAULT NULL,
  `order` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `product_pack` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `deleted_at` datetime(6) DEFAULT NULL,
  `is_active` bit(1) DEFAULT NULL,
  `is_deleted` bit(1) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  `claim_amount` int DEFAULT NULL,
  `code` varchar(255) NOT NULL,
  `fee_type` int NOT NULL,
  `name` varchar(255) NOT NULL,
  `order_no` int NOT NULL,
  `product_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1e898ax9n1n374bv14ixnaj6o` (`product_id`),
  CONSTRAINT `FK1e898ax9n1n374bv14ixnaj6o` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `product_pack_detail` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `deleted_at` datetime(6) DEFAULT NULL,
  `is_active` bit(1) DEFAULT NULL,
  `is_deleted` bit(1) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  `auto_extend_method_cycle` int NOT NULL,
  `cycle_price` double DEFAULT NULL,
  `payment_method` int NOT NULL,
  `type` int NOT NULL,
  `product_pack_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKn8s0rr7mhwdds8cee1vdma48b` (`product_pack_id`),
  CONSTRAINT `FKn8s0rr7mhwdds8cee1vdma48b` FOREIGN KEY (`product_pack_id`) REFERENCES `product_pack` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `product_pack_detail_payment` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `deleted_at` datetime(6) DEFAULT NULL,
  `is_active` bit(1) DEFAULT NULL,
  `is_deleted` bit(1) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  `payment_method_id` bigint DEFAULT NULL,
  `product_detail_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK9jkbs2c76o4kyl88j7qa6x3li` (`payment_method_id`),
  KEY `FKs79gdwm0h6rpp47e06fmcl76g` (`product_detail_id`),
  CONSTRAINT `FK9jkbs2c76o4kyl88j7qa6x3li` FOREIGN KEY (`payment_method_id`) REFERENCES `payment_method` (`id`),
  CONSTRAINT `FKs79gdwm0h6rpp47e06fmcl76g` FOREIGN KEY (`product_detail_id`) REFERENCES `product_pack_detail` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `product_provider` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `deleted_at` datetime(6) DEFAULT NULL,
  `is_active` bit(1) DEFAULT NULL,
  `is_deleted` bit(1) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  `appellation` varchar(255) NOT NULL,
  `avatar_image` varchar(255) DEFAULT NULL,
  `code` varchar(255) NOT NULL,
  `contact` varchar(255) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `hotline` varchar(20) DEFAULT NULL,
  `introduction_content` longtext,
  `name` varchar(255) DEFAULT NULL,
  `phone_number` varchar(20) DEFAULT NULL,
  `status` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `promo_code` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `deleted_at` datetime(6) DEFAULT NULL,
  `is_active` bit(1) DEFAULT NULL,
  `is_deleted` bit(1) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `create_date` datetime(6) DEFAULT NULL,
  `end_date` datetime(6) DEFAULT NULL,
  `issue_date` datetime(6) DEFAULT NULL,
  `msisdn` varchar(255) DEFAULT NULL,
  `promo_code_status` int DEFAULT NULL,
  `start_date` datetime(6) DEFAULT NULL,
  `product_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKsj3apooho7l8ug9hyydu5xis7` (`product_id`),
  CONSTRAINT `FKsj3apooho7l8ug9hyydu5xis7` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `provider_history` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `deleted_at` datetime(6) DEFAULT NULL,
  `is_active` bit(1) DEFAULT NULL,
  `is_deleted` bit(1) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  `approved_by` varchar(255) DEFAULT NULL,
  `product_provider_status` int DEFAULT NULL,
  `product_provider_id` bigint DEFAULT NULL,
  `provider_policy_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKgxdo1xod6drmectwpt0i4ajgh` (`product_provider_id`),
  KEY `FKicele9lgbfbcv5hl3tx84n10m` (`provider_policy_id`),
  CONSTRAINT `FKgxdo1xod6drmectwpt0i4ajgh` FOREIGN KEY (`product_provider_id`) REFERENCES `product_provider` (`id`),
  CONSTRAINT `FKicele9lgbfbcv5hl3tx84n10m` FOREIGN KEY (`provider_policy_id`) REFERENCES `provider_policy` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `provider_policy` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `deleted_at` datetime(6) DEFAULT NULL,
  `is_active` bit(1) DEFAULT NULL,
  `is_deleted` bit(1) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  `effective_from` datetime(6) DEFAULT NULL,
  `effective_to` datetime(6) DEFAULT NULL,
  `number_policy` varchar(255) DEFAULT NULL,
  `product_provider_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKnvcw9xqjwv6aht4eg7h98616m` (`product_provider_id`),
  CONSTRAINT `FKnvcw9xqjwv6aht4eg7h98616m` FOREIGN KEY (`product_provider_id`) REFERENCES `product_provider` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `province` (
  `code` bigint NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `deleted_at` datetime(6) DEFAULT NULL,
  `is_active` bit(1) DEFAULT NULL,
  `is_deleted` bit(1) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `rate_charge` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `deleted_at` datetime(6) DEFAULT NULL,
  `is_active` bit(1) DEFAULT NULL,
  `is_deleted` bit(1) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  `end_date` datetime(6) DEFAULT NULL,
  `policy_group` int DEFAULT NULL,
  `rate_charge_share` double NOT NULL,
  `start_date` datetime(6) DEFAULT NULL,
  `product_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK8tx06x9v2sn6l8afgu3dx33co` (`product_id`),
  CONSTRAINT `FK8tx06x9v2sn6l8afgu3dx33co` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `refresh_token` (
  `token_id` bigint NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `deleted_at` datetime(6) DEFAULT NULL,
  `is_active` bit(1) DEFAULT NULL,
  `is_deleted` bit(1) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  `expiry_dt` datetime(6) NOT NULL,
  `token` varchar(255) NOT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`token_id`),
  UNIQUE KEY `UK_r4k4edos30bx9neoq81mdvwph` (`token`),
  UNIQUE KEY `UK_f95ixxe7pa48ryn1awmh2evt7` (`user_id`),
  CONSTRAINT `FKfgk1klcib7i15utalmcqo7krt` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `role` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `deleted_at` datetime(6) DEFAULT NULL,
  `is_active` bit(1) DEFAULT NULL,
  `is_deleted` bit(1) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_8sewwnpamngi6b1dwaa88askk` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `role_authority` (
  `role_id` bigint NOT NULL,
  `authority_id` bigint NOT NULL,
  KEY `FKpduid6tx7e38l03s86446514r` (`authority_id`),
  KEY `FK2052966dco7y9f97s1a824bj1` (`role_id`),
  CONSTRAINT `FK2052966dco7y9f97s1a824bj1` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`),
  CONSTRAINT `FKpduid6tx7e38l03s86446514r` FOREIGN KEY (`authority_id`) REFERENCES `authorities` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `sys_admin` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `deleted_at` datetime(6) DEFAULT NULL,
  `is_active` bit(1) DEFAULT NULL,
  `is_deleted` bit(1) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `product_provider_id` bigint DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK6xaex7gkkjs4h87pgxuj13brl` (`product_provider_id`),
  KEY `FKgr4i9qnvgmihp43t8k98m68h5` (`user_id`),
  CONSTRAINT `FK6xaex7gkkjs4h87pgxuj13brl` FOREIGN KEY (`product_provider_id`) REFERENCES `product_provider` (`id`),
  CONSTRAINT `FKgr4i9qnvgmihp43t8k98m68h5` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `target_group` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `deleted_at` datetime(6) DEFAULT NULL,
  `is_active` bit(1) DEFAULT NULL,
  `is_deleted` bit(1) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  `code` varchar(255) NOT NULL,
  `description` longtext NOT NULL,
  `index` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `transaction_history` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `campaign_code` varchar(255) DEFAULT NULL,
  `campaign_name` varchar(255) DEFAULT NULL,
  `commission` double DEFAULT NULL,
  `product_pack_name` varchar(255) DEFAULT NULL,
  `product_provider_code` varchar(255) DEFAULT NULL,
  `product_provider_id` varchar(255) DEFAULT NULL,
  `product_provider_name` varchar(255) DEFAULT NULL,
  `amount` double DEFAULT NULL,
  `contract_no` varchar(255) DEFAULT NULL,
  `customer_code` varchar(255) DEFAULT NULL,
  `customer_id` varchar(255) DEFAULT NULL,
  `customer_phone_number` varchar(255) DEFAULT NULL,
  `error_code` varchar(255) DEFAULT NULL,
  `error_message` varchar(255) DEFAULT NULL,
  `order_id` varchar(255) DEFAULT NULL,
  `payment_method` int DEFAULT NULL,
  `policy_code` varchar(255) DEFAULT NULL,
  `policy_group` int DEFAULT NULL,
  `process_code` varchar(255) DEFAULT NULL,
  `process_name` int DEFAULT NULL,
  `product_code` varchar(255) DEFAULT NULL,
  `product_id` varchar(255) DEFAULT NULL,
  `product_name` varchar(255) DEFAULT NULL,
  `proposal_num` varchar(255) DEFAULT NULL,
  `subscription_type` varchar(255) DEFAULT NULL,
  `transaction_date` datetime(6) DEFAULT NULL,
  `transaction_id` varchar(255) DEFAULT NULL,
  `transaction_status` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `deleted_at` datetime(6) DEFAULT NULL,
  `is_active` bit(1) DEFAULT NULL,
  `is_deleted` bit(1) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `cancel_date` datetime(6) DEFAULT NULL,
  `cancellation_reason` varchar(255) DEFAULT NULL,
  `company` varchar(255) DEFAULT NULL,
  `dod` date DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `from_legacy_system` bit(1) NOT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `given_name` varchar(255) DEFAULT NULL,
  `id_number` varchar(50) DEFAULT NULL,
  `is_cancelled` bit(1) NOT NULL,
  `password` varchar(255) NOT NULL,
  `phone_code` varchar(255) DEFAULT NULL,
  `phone_number` varchar(255) DEFAULT NULL,
  `surname` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `role_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKn82ha3ccdebhokx3a8fgdqeyy` (`role_id`),
  CONSTRAINT `FKn82ha3ccdebhokx3a8fgdqeyy` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `ward` (
  `code` bigint NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `deleted_at` datetime(6) DEFAULT NULL,
  `is_active` bit(1) DEFAULT NULL,
  `is_deleted` bit(1) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `district_code` bigint DEFAULT NULL,
  PRIMARY KEY (`code`),
  KEY `FK3x802nplawd033ox9fsntk06u` (`district_code`),
  CONSTRAINT `FK3x802nplawd033ox9fsntk06u` FOREIGN KEY (`district_code`) REFERENCES `district` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;