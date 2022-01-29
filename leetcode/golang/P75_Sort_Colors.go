func sortColors(nums []int)  {
    if len(nums) == 0 {
        return
    }
    k := 0
    j := len(nums)-1
    for i := 0 ; i < len(nums); i++   {
        if nums[i] == 0 && i!= k {
            nums[i],nums[k] = nums[k],nums[i]
            i--
            k++
        }
        if nums[i] == 2 && i!=j {
            nums[i],nums[j] = nums[j],nums[i]
            i--
            j--
        }
        if i >= j {
            break
        }
    }
}
