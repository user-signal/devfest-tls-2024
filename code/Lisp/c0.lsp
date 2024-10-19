(defun filter (fn list)
    (cond ((null list) nil)
          (t (cond ((funcall (eval fn) (car list)) (cons (car list) (filter fn (cdr list))))
                   (t (filter fn (cdr list)))))))

(filter '(lambda (x) (= (mod x 2) 0)) '(1 2 3 4 5 6))
