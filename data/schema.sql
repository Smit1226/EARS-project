CREATE DATABASE
    IF NOT EXISTS ears DEFAULT CHARACTER SET = 'utf8mb4';

CREATE TABLE
    IF NOT EXISTS departments (
        `id` int(11) NOT NULL AUTO_INCREMENT,
        `name` ENUM('CS', 'MATH') NOT NULL,
        PRIMARY KEY (`id`)
    );

CREATE TABLE
    IF NOT EXISTS users (
        `id` int(11) NOT NULL AUTO_INCREMENT,
        `email` varchar(50) NOT NULL,
        `password` varchar(50) NOT NULL,
        `firstName` varchar(50) NOT NULL,
        `lastName` varchar(50) NOT NULL,
        `departmentId` int(11) NOT NULL,
        `role` ENUM('admin', 'regular') NOT NULL,
        `status` ENUM(
            'pending',
            'active',
            'inactive'
        ) NOT NULL,
        `createdAt` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
        `updatedAt` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
        PRIMARY KEY (`id`),
        FOREIGN KEY (`departmentId`) REFERENCES `departments` (`id`)
    );

CREATE TABLE
    IF NOT EXISTS facultySearches (
        `id` int(11) NOT NULL AUTO_INCREMENT,
        `title` varchar(50) NOT NULL,
        `startDate` TIMESTAMP,
        `endDate` TIMESTAMP,
        `status` ENUM('active', 'inactive'),
        PRIMARY KEY (`id`)
    );

CREATE TABLE
    IF NOT EXISTS members(
        `id` int(11) NOT NULL AUTO_INCREMENT,
        `role` ENUM('member', 'chair'),
        `userId` int(11) NOT NULL,
        `facultySearchId` int(11) NOT NULL,
        PRIMARY KEY (`id`),
        FOREIGN KEY (`userId`) REFERENCES `users` (`id`),
        FOREIGN KEY (`facultySearchId`) REFERENCES `facultySearches` (`id`)
    );

CREATE TABLE
    IF NOT EXISTS applications(
        `id` int(11) NOT NULL AUTO_INCREMENT,
        `applicantProfile` JSON NOT NULL,
        `status` ENUM('accept', 'reject', 'pending'),
        `assignedDate` TIMESTAMP,
        `submitDate` TIMESTAMP,
        `assignTo` int(11) DEFAULT NULL,
        `facultySearchId` int(11) NOT NULL,
        PRIMARY KEY (`id`),
        FOREIGN KEY (`assignTo`) REFERENCES `members` (`id`),
        FOREIGN KEY (`facultySearchId`) REFERENCES `facultySearches` (`id`)
    );

CREATE TABLE
    IF NOT EXISTS `comments`(
        `id` int(11) NOT NULL AUTO_INCREMENT,
        `applicationId` int(11) DEFAULT NULL,
        `content` VARCHAR(500) NOT NULL,
        `createdAt` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
        `updatedAt` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
        `author` int(11) DEFAULT NULL,
        PRIMARY KEY (`id`),
        FOREIGN KEY (`applicationId`) REFERENCES `applications` (`id`),
        FOREIGN KEY (`author`) REFERENCES `users` (`id`)
    );