package com.threading;

public class TypeofMultithreading {

	// Coarse-grained multi threading
	// The simplest type of multi threading occurs when one thread runs until it
	// is blocked by an event that normally would create a long-latency stall.
	//
	// For example:
	// Cycle i: instruction j from thread A is issued.
	// Cycle i + 1: instruction j + 1 from thread A is issued.
	// Cycle i + 2: instruction j + 2 from thread A is issued, which is a load
	// instruction that misses in all caches.
	// Cycle i + 3: thread scheduler invoked, switches to thread B.
	// Cycle i + 4: instruction k from thread B is issued.
	// Cycle i + 5: instruction k + 1 from thread B is issued.
	//
	// Interleaved multi threading
	//
	// it is similar to preemptive multitasking used in operating systems; an
	// analogy would be that the time slice given to each active thread is one
	// CPU cycle.
	//
	// For example:
	// Cycle i + 1: an instruction from thread B is issued.
	// Cycle i + 2: an instruction from thread C is issued.
	//
	//
	// Simultaneous multithreading: possible with multi core processor
	// For example:
	// Cycle i: instructions j and j + 1 from thread A and instruction k from
	// thread B are simultaneously issued.
	// Cycle i + 1: instruction j + 2 from thread A, instruction k + 1 from
	// thread B, and instruction m from thread C are all simultaneously issued.
	// Cycle i + 2: instruction j + 3 from thread A and instructions m + 1 and m
	// + 2 from thread C are all simultaneously issued.
	//
	// Parallel computing is a type of computation in which many calculations or
	// the execution of processes are carried out simultaneously.[1] Large
	// problems can often be divided into smaller ones, which can then be solved
	// at the same time. There are several different forms of parallel
	// computing: bit-level, instruction-level, data, and task parallelism
	//
	//
}
