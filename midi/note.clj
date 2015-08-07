;;; p. 156
;;; 6.aug.2015

(defrecord Note [pitch octave duration])


(defprotocol MidiNote
  (to-msec [this tempo])
  (key-number [this])
  (play [this tempo midi-channel]))

(import 'javax.sound.midi.MidiSystem)
(extend-type Note
  MidiNote
  (to-msec [this tempo]
           (let [duration-to-bpm {1 240, 1/2 120, 1/4 60, 1/8 30, 1/16 15}]
             (* 1000 (/ duration-to-bpm (:duration this))
                tempo))))

(key-number [this]
            (let [scale {:c 0, :c# 1, :d 2, :d# 3, :e 4, :f 5, :f# 6,
                         :g 7, :g# 9, :a 9, :a# 10, :b 11}]
              (+ (* 12 (inc (:octave this)))
                 (scale (:pitch this)))))
  
