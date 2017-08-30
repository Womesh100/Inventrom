import time
import tweepy

consumer_key=''
consumer_secret=''
access_token=''
access_token_secret=''

auth = tweepy.OAuthHandler(consumer_key, consumer_secret)
auth.set_access_token(access_token, access_token_secret)
api = tweepy.API(auth)

'''.......printing list of all following.............. '''

sleeptime = 4
pages = tweepy.Cursor(api.followers, screen_name="boltiot").pages()

while True:
    try:
        page = next(pages)
        time.sleep(sleeptime)
    except tweepy.TweepError: #taking extra care of the "rate limit exceeded"
        time.sleep(60*15) 
        page = next(pages)
    except StopIteration:
        break
    for user in page:
       print(user.screen_name)

'''......printing list of all followers.............'''

sleeptime = 4
pages = tweepy.Cursor(api.friends, screen_name="boltiot").pages()


while True:
    try:
        page = next(pages)
        time.sleep(sleeptime)
    except tweepy.TweepError: #taking extra care of the "rate limit exceeded"
        time.sleep(60*15) 
        page = next(pages)
    except StopIteration:
        break
    for user in page:
       print(user.screen_name)
