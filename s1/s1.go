package main

import (
	"fmt"
	"os"
)


func main() {
	var n int
	fmt.Scanf("%d", &n)
	inp := make([]int, n)
	color, count := 0, -1
	for i := 0; i < n; i++ {
		fmt.Scanf("%d", &inp[i])

		if count == -1 {
			color, count = inp[i], 1
		} else if color == inp[i] {
			count++
		} else if color != inp[i] {
			if count > 0 {
				count--
			} else {
				color, count = inp[i], 1
			}
		}
	}

	cnt := 0
	for i := 0; i < n; i++ {
		if (inp[i] == color) {
			cnt++
		}
	}
	
	if (cnt <= n / 2) {
		fmt.Println("bad input")
		os.Exit(1)
	}

	fmt.Println(color)
}