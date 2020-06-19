# coding=utf-8
import sys


def func(a=''):
    print(a)
    a = a.strip()[1:-1].decode('utf-8')
    print(a)
    print(type(a))
    # for i in a:
    print(a.encode('raw_unicode_escape').decode())


if __name__ == '__main__':
    a = []
    for i in range(1, len(sys.argv)):
        a.append((sys.argv[i]))
    func(a[0])
