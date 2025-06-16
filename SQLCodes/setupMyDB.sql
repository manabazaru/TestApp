-- ───────────────────────────────────────────────────────────────
-- 既存テーブルがあれば削除
-- ───────────────────────────────────────────────────────────────
DROP TABLE IF EXISTS orderDetail;
DROP TABLE IF EXISTS orderMaster;
DROP TABLE IF EXISTS item;
DROP TABLE IF EXISTS member;

-- ───────────────────────────────────────────────────────────────
-- memberテーブル
-- ───────────────────────────────────────────────────────────────
CREATE TABLE member (
  memberCode CHAR(9)      NOT NULL PRIMARY KEY,
  memberName VARCHAR(100) NOT NULL,
  mail       VARCHAR(100) NOT NULL,
  password   VARCHAR(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ───────────────────────────────────────────────────────────────
-- itemテーブル
-- ───────────────────────────────────────────────────────────────
CREATE TABLE item (
  itemCode CHAR(10)      NOT NULL PRIMARY KEY,
  itemName VARCHAR(100)  NOT NULL,
  price    INT           NOT NULL,
  stock    INT           NOT NULL,
  saleDate DATE          NOT NULL,
  city     VARCHAR(100)   NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ───────────────────────────────────────────────────────────────
-- orderMasterテーブル
-- ───────────────────────────────────────────────────────────────
CREATE TABLE orderMaster (
  orderNo     INT      NOT NULL AUTO_INCREMENT PRIMARY KEY,
  totalPrice  INT      NOT NULL,
  memberCode  CHAR(9)  NOT NULL,
  FOREIGN KEY (memberCode) REFERENCES member(memberCode)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ───────────────────────────────────────────────────────────────
-- orderDetailテーブル
-- ───────────────────────────────────────────────────────────────
CREATE TABLE orderDetail (
  orderNo   INT         NOT NULL,
  itemName  VARCHAR(100) NOT NULL,
  price     INT         NOT NULL,
  quantity  INT         NOT NULL,
  PRIMARY KEY (orderNo, itemName),
  FOREIGN KEY (orderNo) REFERENCES orderMaster(orderNo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


-- ───────────────────────────────────────────────────────────────
-- memberデータ（20件）
-- ───────────────────────────────────────────────────────────────
INSERT INTO member (memberCode, memberName, mail, password) VALUES
  ('MBR000001','Member 1','member1@example.com', 'password1'),
  ('MBR000002','Member 2','member2@example.com', 'password2'),
  ('MBR000003','Member 3','member3@example.com', 'password3'),
  ('MBR000004','Member 4','member4@example.com', 'password4'),
  ('MBR000005','Member 5','member5@example.com', 'password5'),
  ('MBR000006','Member 6','member6@example.com', 'password6'),
  ('MBR000007','Member 7','member7@example.com', 'password7'),
  ('MBR000008','Member 8','member8@example.com', 'password8'),
  ('MBR000009','Member 9','member9@example.com', 'password9'),
  ('MBR000010','Member 10','member10@example.com', 'password10'),
  ('MBR000011','Member 11','member11@example.com', 'password11'),
  ('MBR000012','Member 12','member12@example.com', 'password12'),
  ('MBR000013','Member 13','member13@example.com', 'password13'),
  ('MBR000014','Member 14','member14@example.com', 'password14'),
  ('MBR000015','Member 15','member15@example.com', 'password15'),
  ('MBR000016','Member 16','member16@example.com', 'password16'),
  ('MBR000017','Member 17','member17@example.com', 'password17'),
  ('MBR000018','Member 18','member18@example.com', 'password18'),
  ('MBR000019','Member 19','member19@example.com', 'password19'),
  ('MBR000020','Member 20','member20@example.com', 'password20');

-- ───────────────────────────────────────────────────────────────
-- itemデータ（20件）
-- ───────────────────────────────────────────────────────────────
INSERT INTO item (itemCode, itemName, price, stock, saleDate, city) VALUES
  ('ITEM000001','Item 1',   100,  10,'2025-06-01', 'tokyo'),
  ('ITEM000002','Item 2',   200,  20,'2025-06-01', 'Saitama'),
  ('ITEM000003','Item 3',   300,  30,'2025-06-01', 'Kanagawa'),
  ('ITEM000004','Item 4',   400,  40,'2025-06-01', 'tokyo'),
  ('ITEM000005','Item 5',   500,  50,'2025-06-01', 'Saitama'),
  ('ITEM000006','Item 6',   600,  60,'2025-06-01', 'Kanagawa'),
  ('ITEM000007','Item 7',   700,  70,'2025-06-01', 'tokyo'),
  ('ITEM000008','Item 8',   800,  80,'2025-06-01', 'Saitama'),
  ('ITEM000009','Item 9',   900,  90,'2025-06-01', 'Kanagawa'),
  ('ITEM000010','Item 10',1000, 100,'2025-06-01', 'tokyo'),
  ('ITEM000011','Item 11',1100, 110,'2025-06-01', 'Saitama'),
  ('ITEM000012','Item 12',1200, 120,'2025-06-01', 'Kanagawa'),
  ('ITEM000013','Item 13',1300, 130,'2025-06-01', 'tokyo'),
  ('ITEM000014','Item 14',1400, 140,'2025-06-01', 'Saitama'),
  ('ITEM000015','Item 15',1500, 150,'2025-06-01', 'Kanagawa'),
  ('ITEM000016','Item 16',1600, 160,'2025-06-01', 'tokyo'),
  ('ITEM000017','Item 17',1700, 170,'2025-06-01', 'Saitama'),
  ('ITEM000018','Item 18',1800, 180,'2025-06-01', 'Kanagawa'),
  ('ITEM000019','Item 19',1900, 190,'2025-06-01', 'tokyo'),
  ('ITEM000020','Item 20',2000, 200,'2025-06-01', 'Saitama'),
  ('ITEM000021','Item 21',2100, 210,'2025-06-30', 'Kanagawa'),
  ('ITEM000022','Item 22',2200, 220,'2025-07-03', 'tokyo'),
  ('ITEM000023','Item 23',2300, 230,'2025-07-06', 'Saitama'),
  ('ITEM000024','Item 24',2400, 240,'2025-07-09', 'Kanagawa'),
  ('ITEM000025','Item 25',2500, 250,'2025-07-12', 'tokyo');

-- ───────────────────────────────────────────────────────────────
-- orderMasterデータ（20件）
--  注文 1 と 2 は複数商品分の合計額を指定
-- ───────────────────────────────────────────────────────────────
INSERT INTO orderMaster (orderNo, totalPrice, memberCode) VALUES
  ( 1,   100*2 + 200*1, 'MBR000001'),  -- 100×2 + 200×1 = 400
  ( 2,   300*3 + 500*2, 'MBR000002'),  -- 300×3 + 500×2 = 1900
  ( 3,   300*4,         'MBR000003'),
  ( 4,   400*5,         'MBR000004'),
  ( 5,   500*1,         'MBR000005'),
  ( 6,   600*2,         'MBR000006'),
  ( 7,   700*3,         'MBR000007'),
  ( 8,   800*4,         'MBR000008'),
  ( 9,   900*5,         'MBR000009'),
  (10, 1000*1,         'MBR000010'),
  (11, 1100*2,         'MBR000011'),
  (12, 1200*3,         'MBR000012'),
  (13, 1300*4,         'MBR000013'),
  (14, 1400*5,         'MBR000014'),
  (15, 1500*1,         'MBR000015'),
  (16, 1600*2,         'MBR000016'),
  (17, 1700*3,         'MBR000017'),
  (18, 1800*4,         'MBR000018'),
  (19, 1900*5,         'MBR000019'),
  (20, 2000*1,         'MBR000020');

-- ───────────────────────────────────────────────────────────────
-- orderDetailデータ（22件: 注文1と2が複数商品）
-- ───────────────────────────────────────────────────────────────
INSERT INTO orderDetail (orderNo, itemName, price, quantity) VALUES
  -- orderNo = 1 に 2種類の商品
  ( 1, 'Item 1',   100, 2),
  ( 1, 'Item 2',   200, 1),

  -- orderNo = 2 に 2種類の商品
  ( 2, 'Item 3',   300, 3),
  ( 2, 'Item 5',   500, 2),

  -- その他の注文は単一商品
  ( 3, 'Item 3',   300, 4),
  ( 4, 'Item 4',   400, 5),
  ( 5, 'Item 5',   500, 1),
  ( 6, 'Item 6',   600, 2),
  ( 7, 'Item 7',   700, 3),
  ( 8, 'Item 8',   800, 4),
  ( 9, 'Item 9',   900, 5),
  (10, 'Item 10',1000, 1),
  (11, 'Item 11',1100, 2),
  (12, 'Item 12',1200, 3),
  (13, 'Item 13',1300, 4),
  (14, 'Item 14',1400, 5),
  (15, 'Item 15',1500, 1),
  (16, 'Item 16',1600, 2),
  (17, 'Item 17',1700, 3),
  (18, 'Item 18',1800, 4),
  (19, 'Item 19',1900, 5),
  (20, 'Item 20',2000, 1);
