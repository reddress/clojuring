(defn total-cost
  ([item-cost]
   (total-cost item-cost 1))
  ([item-cost num]
   (* item-cost num)))
