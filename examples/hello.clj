(ns examples.hello
  (:gen-class))

(defn -main
  [name]
  (println (str "Oh, hi " name "!")))

(compile 'examples.hello)
