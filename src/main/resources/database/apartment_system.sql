create table book_room
(
    id           int auto_increment
        primary key,
    user_name    varchar(56)  not null comment '入住用户姓名
',
    id_card      varchar(256) not null comment '身份证号',
    room_nummber int          not null comment '入住房间号
',
    in_time      datetime     not null comment '入住时间
',
    out_time     datetime     null comment '离开时间
',
    deposit      int          null comment '定金
'
);

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

create table message
(
    id          int auto_increment
        primary key,
    user_name   varchar(56)   not null,
    user_type   int default 0 not null,
    title       varchar(256)  not null,
    description varchar(256)  null
);

create table room_manage
(
    id        int auto_increment comment '主键id'
        primary key,
    room_nums int default 103 null comment '房间号',
    username  varchar(56)     null comment '入住用户名字',
    check_in  int default 0   not null comment '是否入住0为未入住',
    status    int default 1   null comment '是否禁用0为禁用',
    in_time   datetime        null comment '入住时间',
    out_time  datetime        null comment '离开时间'
);

create table user
(
    id        int auto_increment
        primary key,
    user_name varchar(56)   not null comment '用户登录名字',
    password  varchar(56)   not null comment '用户登录密码
',
    type      int default 0 null comment '0是学生1是管理员
',
    constraint user_user_name_uindex
        unique (user_name)
);


