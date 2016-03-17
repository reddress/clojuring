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

(defn read-components [content-map]
  (println (content-map 0) (content-map 1) (content-map 2)))

(defn pages [content-list]
  (doseq [content content-list]
    (apply page content)))

(pages [["file1" "title1" "content1"]
        ["file2" "title2" "content2"]])
