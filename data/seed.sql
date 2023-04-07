-- Seed test data

INSERT INTO departments VALUES (1, 'cs');

INSERT INTO departments VALUES (2, 'math');

INSERT INTO
    users (
        `id`,
        `email`,
        `password`,
        `firstName`,
        `lastName`,
        `role`,
        `departmentId`
    )
VALUES (
        1,
        'admin@algomau.ca',
        '12345678',
        'Admin',
        'Algoma',
        'admin',
        1
    );

INSERT INTO
    users (
        `id`,
        `email`,
        `password`,
        `firstName`,
        `lastName`,
        `role`,
        `departmentId`
    )
VALUES (
        2,
        'user1@algomau.ca',
        '12345678',
        'smit',
        'shiroya',
        'regular',
        2
    );

INSERT INTO
    users (
        `id`,
        `email`,
        `password`,
        `firstName`,
        `lastName`,
        `role`,
        `departmentId`
    )
VALUES (
        3,
        'user2@algomau.ca',
        '12345678',
        'patel',
        'sarkar',
        'regular',
        2
    );

INSERT INTO
    users (
        `id`,
        `email`,
        `password`,
        `firstName`,
        `lastName`,
        `role`,
        `departmentId`
    )
VALUES (
        4,
        'user3@algomau.ca',
        '12345678',
        'nick',
        'Jones',
        'regular',
        1
    );

INSERT INTO
    facultySearches (
        `id`,
        `title`,
        `startDate`,
        `endDate`,
        `status`
    )
VALUES (
        1,
        'Software Engineering Faculty Search',
        '2023-01-25 12:44:01',
        '2023-03-25 12:44:01',
        'active'
    );

INSERT INTO
    facultySearches (
        `id`,
        `title`,
        `startDate`,
        `endDate`,
        `status`
    )
VALUES (
        2,
        'Math Professor Search',
        '2023-01-25 12:44:01',
        '2023-03-25 12:44:01',
        'active'
    );

INSERT INTO
    facultySearches (
        `id`,
        `title`,
        `startDate`,
        `endDate`,
        `status`
    )
VALUES (
        3,
        'Part time Computer Science Professor',
        '2023-01-25 12:44:01',
        '2023-03-25 12:44:01',
        'active'
    );

INSERT INTO
    members (
        `id`,
        `role`,
        `userId`,
        `facultySearchId`
    )
VALUES (1, 'member', 1, 1);

INSERT INTO
    members (
        `id`,
        `role`,
        `userId`,
        `facultySearchId`
    )
VALUES (2, 'member', 1, 2);

INSERT INTO
    members (
        `id`,
        `role`,
        `userId`,
        `facultySearchId`
    )
VALUES (3, 'member', 1, 3);

INSERT INTO
    applications (
        `id`,
        `applicantProfile`,
        `status`,
        `assignedDate`,
        `submitDate`,
        `assignTo`,
        `facultySearchId`
    )
VALUES (
        1,
        '{
            "firstName":"Alex", 
            "lastName":"Hu", 
            "phone":"(657)789-6543", 
            "email":"alexhu@gmail.com", 
            "address":"12 Queen St",
            "city":"Toronto",
            "province":"Ontario",
            "position":"Professor",
            "department":"Computer Science",
            "experience1":"Toronto University, Professor, Department of Computer Science, 2000-2005",
            "experience2":"York University, Professor,  Department of Computer Science, 2000-2005",
            "education1":"Toronto University, The Bacholor of Computer Science, 1993-1997",
            "education2":"Toronto University, The Master of Computer Science, 1998-1999"
        }',
        'pending',
        DEFAULT,
        DEFAULT,
        null,
        1
    );