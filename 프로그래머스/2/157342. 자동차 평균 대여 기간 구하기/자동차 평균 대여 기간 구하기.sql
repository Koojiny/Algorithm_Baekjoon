-- 코드를 입력하세요
SELECT a.CAR_ID, ROUND(AVG(DATEDIFF(a.END_DATE, a.START_DATE) + 1), 1) AS AVERAGE_DURATION
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY a
GROUP BY CAR_ID
HAVING AVERAGE_DURATION >= 7
ORDER BY AVERAGE_DURATION DESC, CAR_ID DESC