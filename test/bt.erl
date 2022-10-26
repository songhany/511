-module(bt).
-compile(export_all).

%% {empty} this is empty binary tree
%% {node, D, LT, RT} is the non-rmpty binary tree

%%     7
%%   /  \
%%  3   73
%%      /
%%    33

fact(0) ->
  1;
fact(N) when N > 0 ->   %% guards
  N * fact(N-1).

t1() -> 
  {node, 7,
    {node, 3, {empty}, {empty}},
    {node, 73,
      {node, 33, {empty}, {empty}},
      {empty}}}.

sizet({empty}) -> 
  0;
sizet({node, _D, LT, RT}) -> 
  1 + sizet(LT) + sizet(RT).

mirrort({empty}) ->
  {empty};
mirrort({node, D, LT, RT}) ->
  {node, D, mirrort(RT), mirrort(LT)}.
