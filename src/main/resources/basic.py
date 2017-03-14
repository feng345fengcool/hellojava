__author__ = 'chenshuai'

cast = ["Cleese", "Plain", "Jones", "Idle"]
print cast
print len(cast)
print cast[1]
cast.append("Gilliam")
print cast
cast.pop()
print cast
cast.extend(["Gilliam", "Chapman"])
print cast
cast.remove("Chapman")
print cast
cast.insert(0, "Chapman")
print cast

movies = ["The Holy Grail", "The Life of Brian", "The Meaning of Life"]
movies.insert(1, 1975)
movies.insert(3, 1979)
movies.append(1983)

fav_movies = ["The Holy Grail", "The Life of Brain"]
for each_flick in fav_movies:
    print(each_flick)

# movies = [[],[],[]]
print movies[4][1][3]
print isinstance(movies, list)  # True
print isinstance(len(movies), list)  # False


# nester.py
# default value is not necessary
def print_lol(the_list, indent=False, level=0, fh=sys.stdou):
    for each_item in the_list:
        if isinstance(each_item, list):
            print_lol(each_item, indent, level+1, fh)
        else:
            if indent:
                for tab_stop in range(level):
                    print "\t"
            print each_item
            # print(each_item, end='', file=fh) python3


# python PyPI
# perl CPAN


"""This is the standard way to include a multiple-line comment in your code."""
"""import sys; print(sys.path); the location of python lib"""
"""pyc file === java class file"""

# list()
# range()
# enumerate()
# int()
# id()
# next()

import os
print os.chdir("../")
print os.getcwd()

data = open("sketch.txt")
print data.readline()
data.seek(0)


# Man: Is this the right room for an argument?
# Other Man: I've told you once.
# Man: No you haven't!
# Other Man: Yes I have.
# Man: When?
# Other Man: Just now.
# Man: No you didn't

if os.path.exists("readme.txt"):
    data = open("readme.txt")
    for each_line in data:
        if not each_line.find(":") == -1:
            try:
                # split: Immutable parameters
                (role, line_spoken) = each_line.split(":", 1)
                print role
                print line_spoken
            # focus your job's content
            except ValueError:
                pass
    data.close()
else:
    print "The data file is missing !"


# try/except/finally
man = []
other = []
try:
    data = open("sketch.txt")
    for each_line in data:
        try:
            (role, line_spoken) = each_line.split(":", 1)
            line_spoken = line_spoken.strip()
            if role == "Man":
                man.append(line_spoken)
            elif role == 'Other Man':
                other.append(line_spoken)
        except ValueError as err:
            print "File error: " + str(err)
            pass
        # call locals() before call close()
        # locals() BIF
        finally:
            if 'data' in locals():
                data.close()
except IOError:
    print "The datafile is missing !"
print man
print other

"""with is equals try/except/finally, with use a kind of context management protocol python tech"""
try:
    with open("its.txt", "w") as data:
        data.write("It's...")
except IOError as err:
    print "File error: " + str(err)
"""||"""
"""||"""
"""||"""
"""with is equals try/except/finally, with use a kind of context management protocol python tech"""
try:
    data = open("its.txt", "w")
    data.write("It's...")
except IOError as err:
    print "File error: " + str(err)
finally:
    if "data" in locals():
        data.close()

with open("man_data.txt", "w") as man_file, open("other_data.txt", "w") as other_file:
    # data in memory
    print man_file.readlines()
    # data in memory
    print other_file.readlines()


# dump load; must use binary
import pickle
try:
    with open("mydata.pickle", "wb") as mysavedata:
        pickle.dump([1, 2, 'three'], mysavedata)

    with open("mydata.pickle", "rb") as myrestoredata:
        a_list = pickle.load(myrestoredata)
    print a_list
except IOError as err:
    print "File error: " + str(err)
except pickle.PickleError as pickle_err:
    print "Pickling error: " + str(pickle_perr)


# In-place sorting
print data.sort()
# Copied sorting
print sorted(data)


def sanitize(time_string):
    if "-" in time_string:
        splitter = "-"
    elif ":" in time_string:
        splitter = ":"
    else:
        return time_string
    mins, secs = time_string.split(splitter)
    return mins + "." + secs

# create convert iterate append
clean_mikey = [sanitize(each_t) for each_t in mikey]
print sorted(set([sanitize(each_t) for each_t in mikey]), reverse=True)[0:3]


# pop
def get_coach_data(filename):
    try:
        with open(filename) as f:
            data = f.readline()
        templ = data.strip().split(",")
        return {
            "name": templ.pop(0),
            "dob": templ.pop(0),
            "times": str(sorted(set(sanitize(t) for t in sarah_data["times"]))[0:3])
        }
    except IOError as ioerr:
        print "File error: " + str(ioerr)
        return None

# class


class Athlete:
    def __init__(self, a_name, a_dob=None, a_times=[]):
        self.name = a_name
        self.dob = a_dob
        self.times = a_times

    def top3(self):
        return sorted(set([sanitize(t) for t in self.times]))[0:3]

    def add_time(self, time_value):
        self.times.append(time_value)

    def add_times(self, list_of_times):
        self.times.extend(list_of_times)

sarah = Athlete("Sarah Sweeney", "2002-6-17", ["2:58", "2.58", "1.56"])
james = Athlete("James Jones")

print str(sarah.top3())
print str(james.top3())

