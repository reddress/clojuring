(def column-offset 10)
(def min-line-length 11)

(def summary-lines (clojure.string/split (slurp "summary.clj") #"\r\n"))

(comment (def entries (filter #(> (count %) 3)
                              (map #(apply str (drop column-offset %))
                                   summary-lines))))

(def meaningful-lines (filter #(> (count %) min-line-length) summary-lines))

(def entries (for [line meaningful-lines]
               [(apply str (drop column-offset line)) line]))

(def sorted-entries (sort entries))

(def output (clojure.string/join "\r\n" (map #(get % 1) sorted-entries)))

(spit "summary-sorted.clj"
      (str
       ";;;; "
       (.toString (new java.util.Date))
       "\r\n\r\n"
       output))

