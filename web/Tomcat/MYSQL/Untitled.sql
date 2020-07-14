SELECT * FROM project.member;

SELECT `member`.`idx`,
    `member`.`uid`,
    `member`.`upw`,
    `member`.`uname`,
    `member`.`uphoto`,
    `member`.`regdate`
FROM `project`.`member`;

INSERT INTO `project`.`member`
(
`uid`,`upw`,`uname`,`uphoto`
)
VALUES
('cool','1111','COOL',null);

UPDATE `project`.`member`
SET
`idx` = <{idx: }>,
`uid` = <{uid: }>,
`upw` = <{upw: }>,
`uname` = <{uname: }>,
`uphoto` = <{uphoto: }>,
`regdate` = <{regdate: CURRENT_TIMESTAMP}>
WHERE `idx` = <{expr}>;



