LISP
====
LISt Programming Language

wiki: http://en.wikipedia.org/wiki/Lisp_(programming_language)
LISP: LISt Processing

Appeared in 1958
Designed by John McCarthy


Set up LISP enviroments:
-----------------------
Getting Going With Modern Common Lisp on Linux.
http://www.mohiji.org/2011/01/31/modern-common-lisp-on-linux/

Install SBCL (Steel Bank Common LISP)

http://www.sbcl.org/platform-table.html

SBCL installation log

At this point, SBCL is installed into /usr/local/bin, you should be able to run "sbcl" and get a Lisp prompt:


gtec-ipworks201:~ # sbcl

This is SBCL 1.2.7, an implementation of ANSI Common Lisp.
More information about SBCL is available at <http://www.sbcl.org/>.

SBCL is free software, provided as is, with absolutely no warranty.
It is mostly in the public domain; some portions are provided under
BSD-style licenses.  See the CREDITS and COPYING files in the
distribution for more information.
*


Install Emacs
For SUSE 11 SP2, use yast2 to install emacs.

gtec-ipworks201:~ # which emacs

/usr/bin/emacs


Install Quicklisp
Download Quicklisp from http://www.quicklisp.org/
Quicklisp makes it easy to get started with a rich set of community-developed Common Lisp libraries.

"Have I said yet how awesome Quicklisp is? All Common Lispers should check it out."  -- Peter seibel

"I must say that I am pleased and impressed." -- Hans Hübner

quicklisp installation log


SBCL and Quicklisp are already playing nicely together at this point; you just need to let Emacs know about them.

First in SBCL run:
(ql:quickload "quicklisp-slime-helper")

This'll install SLIME (http://common-lisp.net/project/slime/) for you, an awesome Common Lisp development enviroment. It should give you a line to add to you .emacs configuration file:

slime-helper.el installed in "/home/leo/quicklisp/slime-helper.el"

To use, add this to your ~/.emacs:

  (load (expand-file-name "/home/leo/quicklisp/slime-helper.el"))
  ;; Replace "sbcl" with the path to your implementation
  (setq inferior-lisp-program "sbcl")



At last, run emacs, M-x slime
Slime requires an Emacs version of 23, or above



-->upgrade emcas on SUSE 11 SP2

default emcas version is: 
GNU Emacs 22.3.1 (x86_64-suse-linux-gnu, GTK+ Version 2.18.9)
 of 2011-09-20 on chopin

Follow the follwing webpage to install GNU Emacs 23.1.1 [emacs-23.1.tar.bz2]
https://www.gnu.org/software/emacs/manual/html_node/efaq/Installing-Emacs.html

  299  2015-01-06 21:50:25 ./configure --without-x
  300  2015-01-06 21:51:01 make
  301  2015-01-06 21:52:30 make install


M-x slime

; SLIME 2014-11-30
CL-USER>


---END---
