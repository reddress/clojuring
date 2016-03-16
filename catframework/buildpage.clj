;;; build an HTML page

(def TARGET-FOLDER "c:/Users/Heitor/Desktop/emacs-24.3/bin/clojuring/catframework/html/")

(defn header [title]
  (str
   "<!DOCTYPE html>
  <html>
  <head>
  <meta charset='utf-8'>
  <title>" title   
   "</title>
  </head>
  "))

(defn footer []
  "</html>")

(defn body [content]
  (str
   "<body>" content
   "</body>"))

(defn page [filename title content]
  (spit (str TARGET-FOLDER filename)
        (str
         (header title)
         (body content)
         (footer))))
