(let [freq-list (reverse
                 (sort-by second (frequencies
                                  (re-seq
                                   #"\([a-z\-]+"
                                   (slurp "my-solutions.clj")))))]
  (for [entry freq-list]
    (prn entry)))
