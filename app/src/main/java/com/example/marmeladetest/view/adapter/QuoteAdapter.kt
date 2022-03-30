package com.example.marmeladetest.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.marmeladetest.R
import com.example.marmeladetest.databinding.ItemQuoteBinding


class QuoteAdapter :
    ListAdapter<QuoteListQuery.Quote, QuoteViewHolder>(QuoteDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuoteViewHolder {
        val binding: ItemQuoteBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_quote,
            parent,
            false
        )
        return QuoteViewHolder(binding)
    }

    override fun onBindViewHolder(holder: QuoteViewHolder, position: Int) {
        holder.binding.quote = getItem(position)
    }

}



class QuoteViewHolder(val binding: ItemQuoteBinding) : RecyclerView.ViewHolder(binding.root)

class QuoteDiffUtil : DiffUtil.ItemCallback<QuoteListQuery.Quote>() {

    override fun areItemsTheSame(
        oldItem: QuoteListQuery.Quote,
        newItem: QuoteListQuery.Quote
    ): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(
        oldItem: QuoteListQuery.Quote,
        newItem : QuoteListQuery.Quote
    ): Boolean {
        return oldItem == newItem
    }

}