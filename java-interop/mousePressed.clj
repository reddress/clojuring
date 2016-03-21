(import 'java.awt.event.MouseAdapter)
(proxy [MouseAdapter] []
  (mousePressed [event]
    (println "Hey!")))
