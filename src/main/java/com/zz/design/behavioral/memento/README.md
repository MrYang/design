# 备忘录模式

保存一个对象的某个状态，以便在适当的时候恢复对象

主要解决的问题是在不破坏封装的前提下，捕获一个对象的内部状态，并在该对象之外保存这个状态，可以在以后将对象恢复到原先保存的状态

应用场景：1、打游戏时的存档。 2、ctrl + z 撤销。 3、数据库的事务管理