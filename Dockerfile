FROM mongo:7
LABEL authors="manojravikumar"

ENTRYPOINT ["top", "-b"]