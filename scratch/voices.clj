;;;; for use in overtone

;;; given: (play-voices [inst1 inst2 inst3] [[notes1...] [notes2...] [notes3...]])
;;; convert to (play-note inst1 notes1-1) (play-note inst2 notes2-1) etc.

(defn distr [h s]  ;; head and sequence
  ;;; output: [[h s1] [h s2] [h s3] ...]
  (map #(vector h %) s))

(distr :a [1 2 3])

(defn play-voices-hard-coded [insts notes]
  (list 
  (distr (first insts) (first notes))
  (distr (second insts) (second notes))))

(play-voices-hard-coded [:saw :tri] [[:c :g] [:g :d]])

(defn play-voices [insts notes]
  (map #(distr %1 %2) insts notes))

(play-voices [:saw :tri] [[:c :g :a] [:g :d :c]])

