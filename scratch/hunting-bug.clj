(defn my-inv [x]
  (/ 1 x))

(defn g [x]
  (+ 1 (my-inv x)))

(defn h [x]
  (println "called h")
  (* 20 (g x)))

;;; call (h 0)
