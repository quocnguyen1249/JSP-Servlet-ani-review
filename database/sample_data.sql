use reviewanime;

INSERT INTO category (code, name, created_date, created_by) VALUES
('ACTION', 'Hành động', NOW(), 'ReviewAnimeSeeder'),
('ADVENTURE', 'Phiêu lưu', NOW(), 'ReviewAnimeSeeder'),
('FANTASY', 'Viễn tưởng', NOW(), 'ReviewAnimeSeeder'),
('SCIENCE', 'Khoa học', NOW(), 'ReviewAnimeSeeder'),
('SHONEN', 'Shonen', NOW(), 'ReviewAnimeSeeder'),
('FAMILY', 'Gia đình', NOW(), 'ReviewAnimeSeeder'),
('COMEDY', 'Hài hước', NOW(), 'ReviewAnimeSeeder'),
('PSYCHO', 'Tâm lý', NOW(), 'ReviewAnimeSeeder'),
('SUPERNATURAL', 'Siêu nhiên', NOW(), 'ReviewAnimeSeeder'),
('DETECTIVE', 'Trinh thám', NOW(), 'ReviewAnimeSeeder'),
('TECH', 'Công nghệ', NOW(), 'ReviewAnimeSeeder');


INSERT INTO anime (title, thumbnail, shortDescription, content, rating, releaseYear, episodes, status, country, createddate, createdby)
VALUES
('Attack on Titan', 'https://upload.wikimedia.org/wikipedia/vi/8/8d/%C4%90%E1%BA%A1i_chi%E1%BA%BFn_Titan_manga_t%E1%BA%ADp_1_ti%E1%BA%BFng_Vi%E1%BB%87t.png',
 'Nhân loại chiến đấu chống Titan khổng lồ.',
 'Attack on Titan mở ra một thế giới nơi nhân loại bị giam cầm sau những bức tường khổng lồ để tránh sự tàn sát của Titan. Câu chuyện theo chân Eren Yeager, Mikasa và Armin khi họ chứng kiến thảm kịch gia đình bị Titan giết hại. Từ đó, Eren thề sẽ tiêu diệt toàn bộ Titan. Bộ phim không chỉ mang đến những trận chiến nghẹt thở mà còn đào sâu vào bí mật về nguồn gốc Titan, sự thật về thế giới bên ngoài và những âm mưu chính trị phức tạp.',
 4.5, '2013', '25', 'completed', 'Japan', NOW(), 'ReviewAnimeSeeder'),

('Death Note', 'https://upload.wikimedia.org/wikipedia/vi/7/7d/DeathNote_vol1_cover.jpg',
 'Cuốn sổ tử thần giết người bằng cách viết tên.',
 'Death Note kể về Light Yagami, một học sinh trung học thiên tài, tình cờ nhặt được cuốn sổ tử thần có khả năng giết chết bất kỳ ai nếu viết tên họ vào đó. Với tham vọng tạo ra một thế giới không tội phạm, Light trở thành “Kira” và bắt đầu cuộc chiến trí tuệ với thám tử L – người duy nhất có thể ngăn chặn cậu. Bộ phim là màn đấu trí căng thẳng, nơi mỗi bước đi đều có thể dẫn đến chiến thắng hoặc thất bại.',
 4.4, '2006', '37', 'completed', 'Japan', NOW(), 'ReviewAnimeSeeder'),

('Fullmetal Alchemist: Brotherhood', 'https://upload.wikimedia.org/wikipedia/vi/9/9c/Fullmetal_Alchemist_Brotherhood.jpg',
 'Hai anh em luyện kim tìm cách khôi phục cơ thể.',
 'Edward và Alphonse Elric phạm sai lầm khi cố gắng hồi sinh mẹ bằng giả kim thuật. Họ mất đi cơ thể và phải lên đường tìm Hòn đá Triết gia để khôi phục lại bản thân. Bộ phim là hành trình đầy cảm xúc về tình anh em, sự hy sinh và những câu hỏi về đạo đức trong việc sử dụng sức mạnh tuyệt đối.',
 4.6, '2009', '64', 'completed', 'Japan', NOW(), 'ReviewAnimeSeeder'),

('One Punch Man', 'https://upload.wikimedia.org/wikipedia/vi/thumb/e/ea/One_Punch_Man_Vol_1.png/345px-One_Punch_Man_Vol_1.png',
 'Siêu anh hùng Saitama đánh bại mọi đối thủ bằng một cú đấm.',
 'Saitama là một anh hùng bình thường nhưng có sức mạnh vô song. Anh tìm kiếm đối thủ xứng đáng trong khi chiến đấu chống lại quái vật và tham gia Hiệp hội Anh hùng. Bộ phim vừa hài hước vừa kịch tính, châm biếm thể loại siêu anh hùng truyền thống.',
 4.3, '2015', '12', 'completed', 'Japan', NOW(), 'ReviewAnimeSeeder'),

('Demon Slayer (Kimetsu no Yaiba)', 'https://upload.wikimedia.org/wikipedia/vi/0/09/Demon_Slayer_-_Kimetsu_no_Yaiba%2C_volume_1.jpg',
 'Tanjiro bảo vệ em gái Nezuko khỏi quỷ dữ.',
 'Sau khi gia đình bị quỷ sát hại, Tanjiro Kamado chỉ còn lại em gái Nezuko – nhưng cô đã bị biến thành quỷ. Quyết tâm cứu em, Tanjiro gia nhập đội diệt quỷ và bắt đầu hành trình gian khổ. Bộ phim gây ấn tượng với những trận chiến mãn nhãn, tình cảm anh em cảm động và hành trình trưởng thành của Tanjiro.',
 4.2, '2019', '26', 'ongoing', 'Japan', NOW(), 'ReviewAnimeSeeder'),

('Sword Art Online', 'https://upload.wikimedia.org/wikipedia/vi/thumb/3/3e/Sword_Art_Online_light_novel_volume_1_cover.jpg/375px-Sword_Art_Online_light_novel_volume_1_cover.jpg',
 'Người chơi mắc kẹt trong thế giới game VR.',
 'Kirito và hàng ngàn người chơi bị mắc kẹt trong trò chơi thực tế ảo SAO. Nếu chết trong game, họ sẽ chết ngoài đời thực. Kirito phải chiến đấu để thoát ra, đồng thời tìm kiếm tình yêu và tình bạn trong thế giới ảo đầy nguy hiểm.',
 4.0, '2012', '25', 'completed', 'Japan', NOW(), 'ReviewAnimeSeeder'),

('Naruto', 'https://upload.wikimedia.org/wikipedia/vi/c/c7/Naruto_Volume_1_manga_cover.jpg',
 'Hành trình của ninja Naruto để trở thành Hokage.',
 'Naruto Uzumaki, một ninja trẻ mang trong mình Cửu Vĩ Hồ, vượt qua khó khăn và định kiến để theo đuổi ước mơ trở thành Hokage – thủ lĩnh làng Lá. Bộ phim là hành trình trưởng thành, tình bạn và sự kiên trì không bỏ cuộc.',
 4.1, '2002', '220', 'completed', 'Japan', NOW(), 'ReviewAnimeSeeder'),

('Bleach', 'https://upload.wikimedia.org/wikipedia/vi/5/53/Bleach_cover_01.jpg',
 'Ichigo Kurosaki trở thành Thần Chết để bảo vệ thế giới.',
 'Ichigo Kurosaki tình cờ nhận được sức mạnh của Thần Chết. Cậu phải chiến đấu chống lại Hollow và bảo vệ cả thế giới con người lẫn Soul Society. Bộ phim kết hợp hành động mãn nhãn với những câu chuyện về trách nhiệm và sự hy sinh.',
 4.0, '2004', '366', 'completed', 'Japan', NOW(), 'ReviewAnimeSeeder'),

('My Hero Academia', 'https://upload.wikimedia.org/wikipedia/vi/5/5a/Boku_no_Hero_Academia_Volume_1.png',
 'Izuku Midoriya học viện anh hùng để trở thành siêu anh hùng.',
 'Trong một thế giới nơi hầu hết mọi người đều có siêu năng lực, Izuku Midoriya – một cậu bé không có năng lực – vẫn nuôi mơ ước trở thành anh hùng. Được All Might truyền lại sức mạnh, Midoriya bắt đầu hành trình gian khổ tại học viện anh hùng. Bộ phim mang đến thông điệp về niềm tin, sự kiên trì và tinh thần đồng đội.',
 4.2, '2016', '138', 'ongoing', 'Japan', NOW(), 'ReviewAnimeSeeder'),

('Dragon Ball Z', 'https://dragonballwiki.net/wp-content/uploads/2017/12/thumb-1920-606985.jpg',
 'Goku và đồng đội bảo vệ Trái Đất khỏi thế lực hùng mạnh.',
 'Dragon Ball Z theo chân Goku và bạn bè trong những trận chiến chống lại các thế lực hùng mạnh như Frieza, Cell và Majin Buu. Bộ phim nổi tiếng với những màn chiến đấu hoành tráng, tinh thần đồng đội và hành trình bảo vệ vũ trụ khỏi sự hủy diệt.',
 4.3, '1989', '291', 'completed', 'Japan', NOW(), 'ReviewAnimeSeeder');


 use reviewanime;
-- Attack on Titan
INSERT INTO animecategory VALUES (1, 1), (1, 2), (1, 3), (1, 5);

-- Death Note
INSERT INTO animecategory VALUES (2, 8), (2, 9), (2, 10), (2, 5);

-- Fullmetal Alchemist
INSERT INTO animecategory VALUES (3, 1), (3, 2), (3, 4), (3, 3);

-- One Punch Man
INSERT INTO animecategory VALUES (4, 1), (4, 7), (4, 9), (4, 5);

-- Demon Slayer
INSERT INTO animecategory VALUES (5, 1), (5, 2), (5, 9), (5, 5);

-- Sword Art Online
INSERT INTO animecategory VALUES (6, 1), (6, 2), (6, 3), (6, 11);

-- Naruto
INSERT INTO animecategory VALUES (7, 1), (7, 2), (7, 5), (7, 6);

-- Bleach
INSERT INTO animecategory VALUES (8, 1), (8, 9), (8, 2), (8, 5);

-- My Hero Academia
INSERT INTO animecategory VALUES (9, 1), (9, 2), (9, 5), (9, 9);

-- Dragon Ball Z
INSERT INTO animecategory VALUES (10, 1), (10, 2), (10, 3), (10, 5);
