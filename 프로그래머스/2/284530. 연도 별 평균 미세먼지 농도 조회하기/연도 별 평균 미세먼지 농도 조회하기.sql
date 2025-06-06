-- 코드를 작성해주세요
SELECT YEAR(a.YM) AS YEAR, ROUND(AVG(a.PM_VAL1), 2) AS 'PM10', ROUND(AVG(a.PM_VAL2), 2) AS 'PM2.5'
FROM AIR_POLLUTION a
WHERE LOCATION2 = '수원'
GROUP BY YEAR(a.YM)
ORDER BY YEAR