create table good_manage
(
    goods_id     int auto_increment comment '商品ID'
        primary key,
    goods_nums   int         not null comment '商品编号
',
    goods_name   varchar(56) not null comment '商品名称',
    goods_price  float       not null comment '商品单价',
    goods_number int         null comment '商品数量'
);


