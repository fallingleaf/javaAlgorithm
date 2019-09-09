data = []

with open('facebook.txt', 'r') as fd:
    for line in fd:
        parts = line.split(',')
        percent = parts[2][:-1]
        percent = float(percent)
        if percent >= 40.0:
            data.append((percent, line))

data.sort(reverse=True)

with open('shortFb.txt', 'w') as f:
    for (_, d) in data:
        f.write(d + '\n')
