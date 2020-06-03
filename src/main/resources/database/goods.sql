
CREATE TABLE `good_manage` (
  `goods_id` int NOT NULL AUTO_INCREMENT COMMENT '商品ID',
  `goods_nums` int NOT NULL COMMENT '商品编号\n',
  `goods_name` varchar(56) NOT NULL COMMENT '商品名称',
  `goods_price` float DEFAULT NULL COMMENT '商品单价',
  `goods_number` int DEFAULT NULL COMMENT '商品数量',
  PRIMARY KEY (`goods_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci


