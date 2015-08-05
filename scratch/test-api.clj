;;; test API
;;; https://clojure.github.io/clojure/clojure.test-api.html

(use '[clojure.test :only [is]])

(is (= 21 (+ 1 20)))

(is (= 1 2))

(+ (- 1 2) 3)
