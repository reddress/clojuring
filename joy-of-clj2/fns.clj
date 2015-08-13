((fn arities
   ([x] "one")
   ([x y] "two")
   ([x y z] (arities 3)))
 2 3 9)

(defn arity2+ [first second & more]
  (concat (vector first second) (apply vector more)))

((fn arity2+-obvious [first second & more]
   (concat (vector first second) more))
 1 2 3 4 5)

(arity2+ 1 2 3 4 5)

(let [a 1
      b a]
  b)

(defn sum-down-from [sum x]
  (if (pos? x)
    (recur (+ sum x) (dec x))
    sum))
(sum-down-from 0 100)
