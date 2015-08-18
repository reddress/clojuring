;;;; in chapter 6, lazy seq

;;; Given sequential inputs 5, 3, 7, 2
;;; create a binary tree
;;;     5
;;;   3   7
;;; 2

(defn add-to-btree [t n]
  (if (nil? t)
    {:val n :l nil :r nil}
    (if (< n (t :val))
      (assoc t :l (add-to-btree (t :l) n))
      (assoc t :r (add-to-btree (t :r) n)))))

(def t1 {:val 5 :l nil :r nil})

(def t2 (assoc t1 :l {:val 3 :l nil :r nil}))

t2

(add-to-btree
 (add-to-btree
  (add-to-btree
   (add-to-btree
    (add-to-btree
     nil 5) 2) 9) 3) 7)
