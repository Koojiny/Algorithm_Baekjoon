-- 코드를 입력하세요
SELECT  distinct s.CAR_ID,
        s.CAR_TYPE,
        # s.START_DATE,
        # s.END_DATE,
        ROUND(s.tFee) AS FEE
FROM (
        SELECT a.CAR_ID, a.CAR_TYPE, b.START_DATE, b.END_DATE, (a.DAILY_FEE * (100 - c.DISCOUNT_RATE) / 100) * 30 AS tFee
          FROM CAR_RENTAL_COMPANY_CAR a LEFT JOIN CAR_RENTAL_COMPANY_RENTAL_HISTORY b
                                            ON a.CAR_ID = b.CAR_ID
                                        LEFT JOIN CAR_RENTAL_COMPANY_DISCOUNT_PLAN c
                                            ON a.CAR_TYPE = c.CAR_TYPE
         WHERE c.DURATION_TYPE = '30일 이상'
           AND a.CAR_ID NOT IN ( 
                                SELECT CAR_ID
                                  FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
                                 WHERE END_DATE >= '2022-11-01' AND START_DATE <= '2022-12-01')
     ) s
WHERE s.CAR_TYPE IN ('세단', 'SUV')
  # AND (s.START_DATE < '2022-11-01' OR s.START_DATE > '2022-11-30')
  # AND (s.END_DATE < '2022-11-01' OR s.END_DATE > '2022-11-30')
  AND s.tFee >= 500000
  AND s.tFee < 2000000
  
ORDER BY FEE DESC, CAR_TYPE, CAR_ID DESC
  # AND s.CAR_ID NOT IN ( 
  #           SELECT CAR_ID
  #           FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
  #           WHERE END_DATE >= '2022-11-01' AND START_DATE <= '2022-12-01')) 
  
  # SELECT a.CAR_ID, a.CAR_TYPE, (a.DAILY_FEE * (100 - c.DISCOUNT_RATE) / 100) * 30 AS tFee
  #        FROM CAR_RENTAL_COMPANY_CAR a LEFT JOIN CAR_RENTAL_COMPANY_RENTAL_HISTORY b
  #                                           ON a.CAR_ID = b.CAR_ID
  #                                      LEFT JOIN CAR_RENTAL_COMPANY_DISCOUNT_PLAN c
  #                                           ON a.CAR_TYPE = c.CAR_TYPE
  #        WHERE c.DURATION_TYPE = '30일 이상'