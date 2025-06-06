-- 코드를 입력하세요
SELECT  a.REST_ID, a.REST_NAME, a.FOOD_TYPE, a.FAVORITES, a.ADDRESS, ROUND(AVG(b.REVIEW_SCORE), 2) AS SCORE
FROM REST_INFO a INNER JOIN REST_REVIEW b
                    ON a.REST_ID = b.REST_ID
WHERE LEFT(a.ADDRESS, 2) = '서울'
GROUP BY a.REST_ID
ORDER BY SCORE DESC, a.FAVORITES DESC