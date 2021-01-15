

DROP TABLE IF EXISTS `article`;
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

DROP TABLE IF EXISTS `article_category`;
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

DROP TABLE IF EXISTS `authorities`;
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
) ENGINE=InnoDB AUTO_INCREMENT=68 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `authorities_group`;
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
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `benefit`;
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

DROP TABLE IF EXISTS `benefit_setting`;
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

DROP TABLE IF EXISTS `claims`;
CREATE TABLE `claims` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `deleted_at` datetime(6) DEFAULT NULL,
  `is_active` bit(1) DEFAULT NULL,
  `is_deleted` bit(1) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  `amount` double DEFAULT NULL,
  `bringing_fee` bit(1) DEFAULT NULL,
  `bringing_fee_amount` double DEFAULT NULL,
  `component_fee` bit(1) DEFAULT NULL,
  `component_fee_amount` double DEFAULT NULL,
  `contract_code` varchar(255) DEFAULT NULL,
  `customer_code` varchar(255) DEFAULT NULL,
  `employee_name` varchar(255) DEFAULT NULL,
  `employee_phone_number` varchar(255) DEFAULT NULL,
  `insurance_bringing_fee_amount` double DEFAULT NULL,
  `insurance_component_fee_amount` double DEFAULT NULL,
  `insurance_rear_view_mirror_amount` double DEFAULT NULL,
  `insurance_repaint_fee_amount` double DEFAULT NULL,
  `insurance_scratched_fee_amount` double DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `number_bringing` int DEFAULT NULL,
  `number_component` int DEFAULT NULL,
  `number_plate` varchar(255) DEFAULT NULL,
  `number_rear_view_mirror` int DEFAULT NULL,
  `number_repaint` int DEFAULT NULL,
  `number_scratched` int DEFAULT NULL,
  `partner_code` varchar(255) DEFAULT NULL,
  `partner_name` varchar(255) DEFAULT NULL,
  `rear_view_mirror` bit(1) DEFAULT NULL,
  `rear_view_mirror_amount` double DEFAULT NULL,
  `repaint_fee` bit(1) DEFAULT NULL,
  `repaint_fee_amount` double DEFAULT NULL,
  `scratched_fee` bit(1) DEFAULT NULL,
  `scratched_fee_amount` double DEFAULT NULL,
  `status` int DEFAULT NULL,
  `contract_id` bigint DEFAULT NULL,
  `customer_id` bigint DEFAULT NULL,
  `partner_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKcc5d15hc607ial72lhw29lur4` (`contract_id`),
  KEY `FKrol4pvwwwx1lrjp286ggbihd1` (`customer_id`),
  KEY `FKoe6dl2eyaqddpuqyhoqs635d` (`partner_id`),
  CONSTRAINT `FKcc5d15hc607ial72lhw29lur4` FOREIGN KEY (`contract_id`) REFERENCES `contract` (`id`),
  CONSTRAINT `FKoe6dl2eyaqddpuqyhoqs635d` FOREIGN KEY (`partner_id`) REFERENCES `partner` (`id`),
  CONSTRAINT `FKrol4pvwwwx1lrjp286ggbihd1` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `claims_info`;
CREATE TABLE `claims_info` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `deleted_at` datetime(6) DEFAULT NULL,
  `is_active` bit(1) DEFAULT NULL,
  `is_deleted` bit(1) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  `bringing_fee` int DEFAULT NULL,
  `component_fee` int DEFAULT NULL,
  `contract_code` varchar(255) DEFAULT NULL,
  `r_contract_id` bigint DEFAULT NULL,
  `customer_code` varchar(255) DEFAULT NULL,
  `r_customer_id` bigint DEFAULT NULL,
  `number_bringing` int DEFAULT NULL,
  `number_component` int DEFAULT NULL,
  `number_rear_view_mirror` int DEFAULT NULL,
  `number_repaint` int DEFAULT NULL,
  `number_scratched` int DEFAULT NULL,
  `product_code` varchar(255) DEFAULT NULL,
  `r_product_id` bigint DEFAULT NULL,
  `rear_view_mirror` int DEFAULT NULL,
  `repaint_fee` int DEFAULT NULL,
  `scratched_fee` int DEFAULT NULL,
  `contract_id` bigint DEFAULT NULL,
  `customer_id` bigint DEFAULT NULL,
  `product_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKmgumnpphg7d0utieuetugg7tk` (`contract_id`),
  KEY `FK6bgx7i44h7ls4svy4c8gqkbd2` (`customer_id`),
  KEY `FK58pmh4ow25q2sd7tqg6052fc3` (`product_id`),
  CONSTRAINT `FK58pmh4ow25q2sd7tqg6052fc3` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`),
  CONSTRAINT `FK6bgx7i44h7ls4svy4c8gqkbd2` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`),
  CONSTRAINT `FKmgumnpphg7d0utieuetugg7tk` FOREIGN KEY (`contract_id`) REFERENCES `contract` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `contract`;
CREATE TABLE `contract` (
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
  `buyer_id_number` varchar(255) DEFAULT NULL,
  `cancel_date` datetime(6) DEFAULT NULL,
  `car_brand` varchar(255) DEFAULT NULL,
  `car_maker` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `created_contract_date` datetime(6) DEFAULT NULL,
  `customer_code` varchar(255) NOT NULL,
  `dob` datetime(6) DEFAULT NULL,
  `effective_date` datetime(6) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `expired_date` datetime(6) NOT NULL,
  `extend_success_date` datetime(6) DEFAULT NULL,
  `full_name` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `id_number` varchar(255) DEFAULT NULL,
  `number_plate` varchar(255) DEFAULT NULL,
  `paid_amount` double DEFAULT NULL,
  `partner` varchar(255) DEFAULT NULL,
  `partner_code` varchar(255) DEFAULT NULL,
  `payment_status` int NOT NULL,
  `phone_number` varchar(255) DEFAULT NULL,
  `product_code` varchar(255) DEFAULT NULL,
  `product_name` varchar(255) DEFAULT NULL,
  `purchase_method` int NOT NULL,
  `status` varchar(255) DEFAULT NULL,
  `customer_id` bigint DEFAULT NULL,
  `product_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKq28qogy68douoc4gkgcy3ow9p` (`customer_id`),
  KEY `FK6gt1bchn8d85oaq1srbhk31n4` (`product_id`),
  CONSTRAINT `FK6gt1bchn8d85oaq1srbhk31n4` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`),
  CONSTRAINT `FKq28qogy68douoc4gkgcy3ow9p` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `customer`;
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

DROP TABLE IF EXISTS `district`;
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

DROP TABLE IF EXISTS `faq`;
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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `order`;
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
  `customer_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1oduxyuuo3n2g98l3j7754vym` (`customer_id`),
  CONSTRAINT `FK1oduxyuuo3n2g98l3j7754vym` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `partner`;
CREATE TABLE `partner` (
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `product`;
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
  `bringing_fee` int NOT NULL,
  `can_buy_multiple` bit(1) DEFAULT NULL,
  `code` varchar(255) NOT NULL,
  `component_fee` int NOT NULL,
  `detailed_description` longtext NOT NULL,
  `duplicate_buyer_info` bit(1) DEFAULT NULL,
  `effective_date_type` varchar(255) DEFAULT NULL,
  `enable_indemnity` bit(1) DEFAULT NULL,
  `fee_type` varchar(255) NOT NULL,
  `gender_apply` varchar(255) NOT NULL,
  `hide_beneficiary` bit(1) DEFAULT NULL,
  `hide_buyer_info` bit(1) DEFAULT NULL,
  `indemnity_instruction` varchar(255) DEFAULT NULL,
  `indemnity_instruction_content` longtext NOT NULL,
  `indemnity_template` varchar(255) DEFAULT NULL,
  `insured_rule` varchar(255) DEFAULT NULL,
  `is_self_insurance` bit(1) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `number_bringing` int NOT NULL,
  `number_component` int NOT NULL,
  `number_rear_view_mirror` int NOT NULL,
  `number_repaint` int NOT NULL,
  `number_scratched` int NOT NULL,
  `price_obj` double DEFAULT NULL,
  `product_status` int NOT NULL,
  `rear_view_mirror` int NOT NULL,
  `repaint_fee` int NOT NULL,
  `scratched_fee` int NOT NULL,
  `short_description` longtext NOT NULL,
  `video_url` varchar(255) DEFAULT NULL,
  `product_category_id` bigint DEFAULT NULL,
  `target_group_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKcwclrqu392y86y0pmyrsi649r` (`product_category_id`),
  KEY `FKal990foc7b0tlcxducc0u126l` (`target_group_id`),
  CONSTRAINT `FKal990foc7b0tlcxducc0u126l` FOREIGN KEY (`target_group_id`) REFERENCES `target_group` (`id`),
  CONSTRAINT `FKcwclrqu392y86y0pmyrsi649r` FOREIGN KEY (`product_category_id`) REFERENCES `product_category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `product_category`;
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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `product_pack`;
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

DROP TABLE IF EXISTS `product_pack_detail`;
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

DROP TABLE IF EXISTS `product_pack_detail_payment`;
CREATE TABLE `product_pack_detail_payment` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `deleted_at` datetime(6) DEFAULT NULL,
  `is_active` bit(1) DEFAULT NULL,
  `is_deleted` bit(1) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  `product_detail_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKs79gdwm0h6rpp47e06fmcl76g` (`product_detail_id`),
  CONSTRAINT `FKs79gdwm0h6rpp47e06fmcl76g` FOREIGN KEY (`product_detail_id`) REFERENCES `product_pack_detail` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `promo_code`;
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

DROP TABLE IF EXISTS `province`;
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

DROP TABLE IF EXISTS `refresh_token`;
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
  UNIQUE KEY `UK_ga3cqp73wyumau3ghjfx7vq94` (`token`),
  UNIQUE KEY `UK_f95ixxe7pa48ryn1awmh2evt7` (`user_id`),
  CONSTRAINT `FKfgk1klcib7i15utalmcqo7krt` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `role`;
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `role_authority`;
CREATE TABLE `role_authority` (
  `role_id` bigint NOT NULL,
  `authority_id` bigint NOT NULL,
  KEY `FKpduid6tx7e38l03s86446514r` (`authority_id`),
  KEY `FK2052966dco7y9f97s1a824bj1` (`role_id`),
  CONSTRAINT `FK2052966dco7y9f97s1a824bj1` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`),
  CONSTRAINT `FKpduid6tx7e38l03s86446514r` FOREIGN KEY (`authority_id`) REFERENCES `authorities` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `sys_admin`;
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
  KEY `FKeqlehv0xpcblcurwvpegpi5v8` (`product_provider_id`),
  KEY `FKgr4i9qnvgmihp43t8k98m68h5` (`user_id`),
  CONSTRAINT `FKeqlehv0xpcblcurwvpegpi5v8` FOREIGN KEY (`product_provider_id`) REFERENCES `partner` (`id`),
  CONSTRAINT `FKgr4i9qnvgmihp43t8k98m68h5` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `target_group`;
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

DROP TABLE IF EXISTS `transaction_history`;
CREATE TABLE `transaction_history` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `amount` double DEFAULT NULL,
  `contract_code` varchar(255) DEFAULT NULL,
  `customer_code` varchar(255) DEFAULT NULL,
  `customer_name` varchar(255) DEFAULT NULL,
  `customer_phone_number` varchar(255) DEFAULT NULL,
  `effective_date` datetime(6) DEFAULT NULL,
  `expired_date` datetime(6) DEFAULT NULL,
  `partner_code` varchar(255) DEFAULT NULL,
  `partner_name` varchar(255) DEFAULT NULL,
  `payment_method` int DEFAULT NULL,
  `process_code` varchar(255) DEFAULT NULL,
  `process_name` int DEFAULT NULL,
  `product_code` varchar(255) DEFAULT NULL,
  `product_name` varchar(255) DEFAULT NULL,
  `transaction_code` varchar(255) DEFAULT NULL,
  `transaction_date` datetime(6) DEFAULT NULL,
  `transaction_status` int DEFAULT NULL,
  `contract_id` bigint DEFAULT NULL,
  `customer_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKsyl5euhcbbajjyxx985jly760` (`contract_id`),
  KEY `FK88ro5ut6437qycxlhvxcs61uu` (`customer_id`),
  CONSTRAINT `FK88ro5ut6437qycxlhvxcs61uu` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`),
  CONSTRAINT `FKsyl5euhcbbajjyxx985jly760` FOREIGN KEY (`contract_id`) REFERENCES `contract` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `user`;
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
  `is_partner` bit(1) DEFAULT NULL,
  `partner_code` varchar(255) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `phone_code` varchar(255) DEFAULT NULL,
  `phone_number` varchar(255) DEFAULT NULL,
  `surname` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `role_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKn82ha3ccdebhokx3a8fgdqeyy` (`role_id`),
  CONSTRAINT `FKn82ha3ccdebhokx3a8fgdqeyy` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `ward`;
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

