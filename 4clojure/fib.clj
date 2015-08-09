(defn fib-iter [n result]
  (if (= n 2)
    result
    (let [ct (count result)]
      (let [last (nth result (- ct 1))
            penultimate (nth result (- ct 2))]
        (fib-iter (- n 1) (conj result (+ last penultimate)))))))

(fn fib [n] 
  (letfn [(fib-iter [n result]
                    (if (= n 2)
                      result
                      (let [ct (count result)]
                        (let [last (nth result (- ct 1))
                              penultimate (nth result (- ct 2))]
                          (recur (- n 1) (conj result (+ last penultimate)))))))]
    (fib-iter n [1 1])))

(fib 2)
(fib 5)
(fib 8)

(defn single-let-fib [n]
  (letfn [(fib-iter [n result]
                    (if (= n 2)
                      result
                      (let [ct (count result)]
                        (recur (- n 1) (conj result (+ (nth result (- ct 1))
                                                      (nth result (- ct 2))))))))]
    (fib-iter n [1 1])))

(single-let-fib 6)

;;; lazy fib, daowen solution
(defn build-fib [a b]
  (lazy-seq (cons a (build-fib b (+ a b)))))

(take 10 (build-fib 1 1))

(single-let-fib 10)
