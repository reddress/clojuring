;;;; 4clojure #93 Partially flatten a sequence

(def test-case-1 [["Do"] ["nothing"]])
(def test-case-2 [[[[:a :b]]] [[:c :d]] [:e :f]])
(def test-case-3 '((1 2) ((3 4) ((((5 6)))))))
(def test-case-4 '((3 4) ((((5 6))))))
(def test-case-5 '((1 2) (3 4) (5 6)))

(defn is-single-level? [s]
  (every? #(not (coll? %)) s))

(is-single-level? '((1 2 3)))

(map is-single-level? test-case-3)

(defn list-has-only-single-level? [s]
  (every? is-single-level? s))

(list-has-only-single-level? test-case-5)

(partially-flatten test-case-4)

;;; [[3 4] [[[[5 6]]]]] => [[3 4] (to-single-level [[[[5 6]]]])]

(defn to-single-level
  "Given a standalone nested list, reduce depth to a single level"
  [s]
  (cond (not (coll? s)) (vector s)
        (and (coll? s) (not (coll? (first s)))) (vector s)
        :else (to-single-level (first s))))

(to-single-level [[[3 4]]])

(defn partially-flatten-list-of-nested [s]
  (if (not (coll? (first s))) (vector s)
      (mapcat to-single-level s)))

(partially-flatten-list-of-nested test-case-4)

(partially-flatten-list-of-nested '(1 2))

(defn partially-flatten [s]
  (mapcat partially-flatten-list-of-nested s))

(partially-flatten test-case-3)

(to-single-level '(1 2))


(defn partially-flatten-daowen [s]
  (letfn [(eat-a-level [s]
            (if (coll? (first s))
              (partially-flatten-daowen s)
              (vector s)))]
    (mapcat eat-a-level s)))

(partially-flatten-daowen '((1 2) ((3 4) (((5 6) (7 8))))))
