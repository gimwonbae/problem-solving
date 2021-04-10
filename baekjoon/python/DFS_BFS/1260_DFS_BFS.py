# from sys import stdin
# from collections import defaultdict
#
#
# def dfs_bfs():
#     graph = defaultdict(list)
#
#     n, m, first = stdin.readline().rstrip().split()
#     for _ in range(m):
#         key, item = stdin.readline().rstrip().split()
#         graph[key].append(item)
#
#     dfs_discovered = []
#     bfs_discovered = []
#     key_list = list(graph.keys())
#
#     def dfs(v):
#         key_list.remove(v)
#         for w in graph[v]:
#
#             dfs_discovered.append(v)