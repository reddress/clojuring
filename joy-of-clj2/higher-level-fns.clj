;;; p. 143

(defn columns [column-names]
  (fn [row]
    (vec (map row column-names))))

(def bands [{:band "Eno", :plays 2333, :loved 15}
            {:band "Bill", :plays 979, :loved 9}
            {:band "Magma", :plays 2665 :loved 31}])

((columns [:band]) (nth bands 0))

(map (nth bands 0) [:band :plays])
